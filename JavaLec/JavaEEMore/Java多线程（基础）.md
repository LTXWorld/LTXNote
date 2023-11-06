# Java多线程（基础）

## 概念

##进程：

- 运行的程序，OS会为其分配内存空间。
- 动态存在，消亡，释放空间。

## 线程：

### 基本概念

- 由进程创建，是进程的实体
- 一个进程具有多个线程。

1. 单线程 
2. 多线程
3. 并发：宏观上一起执行，实际上**多任务交替切换执行**。
4. 并行：多核CPU——往往并发并行同时存在。

### 创建线程
1. 第一个方法：创建线程有基本的四个步骤：
	- 创建一个继承于Thread的子类
	- 重写Thread的run方法
	- 创建当前子类的对象
	- 通过对象调用start方法，此方法作用：==启动线程、调用run方法==
	- 注意:不能让已经start的线程再次调用start方法

2. 类继承Thread，该类可以当作线程使用；往往重写run方法——**来自于Runnable接口**

   ![](../../../GitT/Pic/%E6%88%AA%E5%B1%8F2023-04-08%2009.09.51.png)
   
   - 点击Run之后，创建了一个进程，启动main线程，再从main主线程启动cat子线程——**最后一个线程结束后，进程也死了**。（而不是主线程死了的原因）启动子线程后，主线程不会阻塞。
   - **启动start会去执行cat的run方法——如果直接用cat.run，相当于主线程去执行run方法，并没有执行多线程**；==本质是start0（）本地方法由JVM调用多线程==。（不同的操作系统有不同的调度方法）
   - start方法调用start0后线程**不会立马执行**，**只是变成了可运行（就绪）状态**，具体由cpu调度。
```java
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();// as a thread to use
        cat.start();//start this thread and use the run ——只有start会真正执行线程，而不是run方法
        //main thread start this thread,the main will continue to go


        //主线程会与cat线程交替执行。当最后一个线程执行结束后，这个进程也就死了。
        for (int i = 1; i < 9; i++) {
            System.out.println("main thread" + i + " " +Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
//
//    @Override
//    public void run() {
//        if (target != null) {
//            target.run();
//        }
//    }
class Cat extends Thread{
    int times = 0;
    @Override
    public void run() {
        // per 1s output "xxx"
        while (true){
            System.out.println("xxx" + (++times)+" the name of this thread " + Thread.currentThread().getName());
            //sleep 1s
            try {
                Thread.sleep(1000);// with ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 8){
                break;//set a time to out this loop//to get out
            }
        }
    }
}
```
3. 实现Runable接口
	- 声明一个类实现runnable接口，重写其中的run方法
	- 创建当前实现类的对象，将此对象作为Thread类对象的参数传递到其构造器中
	- Thread类对象调用start方法

```java
public class RunableTest {
    public static void main(String[] args) {
        OddNum oddNum = new OddNum();
        Thread thread = new Thread(oddNum);
        thread.start();
    }
}
class OddNum implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
```
4. 使用匿名方法实现前两种创建线程

```java
//第一种方法，这个匿名类已经是Thread类的子类了，所以在后面括号里直接重写run方法
new Thread(){
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
//第二种方法，实现的runnable接口要作为Thread的参数，所以写在小括号里面
new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("000000");
            }
        }).start();
```
5. 两种方法对比
	- 一个是类的继承，一个是接口的实现
	- 建议使用后者，避免单继承的局限；多个线程是后者需要更少的实例对象
	- Thread类也实现的是Runnable接口。
	- start方法两个作用：启动线程，调用当前Thread类的run方法
	- 对于执行哪个Run方法：“就近原则”——==当前Thread类的run方法，当前没有才去其他的==

###线程中常用方法
####构造器：

![image-20231014185200085](../../../GitT/Pic/image-20231014185200085.png)

####普通方法：

![image-20231014190533628](../../../GitT/Pic/image-20231014190533628.png)

### 线程优先级
- 优先级方法：set（范围1-10）和get
- 内部设置的优先级：![image-20231014191530617](../../../GitT/Pic/image-20231014191530617.png)
- ==即使优先级有高低也会进行并发执行==

### 生命周期

- 新的版本中，将就绪态与运行态合并在一起：Runnable
- <img src="../../../GitT/Pic/image-20231014193746471.png" alt="image-20231014193746471" style="zoom:50%;" />

### 线程安全同步冲突问题
1. 方法一：同步代码块
- 被synchronized包裹后，这些代码的操作必须被等待；哪个线程获取了同步监视器（锁），即可以进行操作；==锁可以用任何一个类的对象充当，多个线程必须用唯一的一把锁==
- <img src="../../../GitT/Pic/image-20231014205244795.png" alt="image-20231014205244795" style="zoom:50%;" />

2. 方法二：

- 操作共享数据的代码在一个方法中，将此方法声明为同步方法即可。
- 注意，这样的话==同步监视器限定为this==；但也不要刻意变成静态
- 使用此方法得看对象是否唯一，并且此对象一定是被共享的数据部分的对象。

####懒汉式解决线程安全问题
```java
class Bank{
    private Bank (){

    }
    private static Bank instance = null;

    public synchronized static Bank getInstance() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (instance == null){
            instance = new Bank();
        }
        return instance;
    }
}
```
- 为了避免指令重排（即初始化好了对象但还没有init，导致后续的线程将null返回出去），需要将共享属性前加上volatile

####JDK5.0解决的新方法：LOCK锁
- 不需要同步代码块等，使用==两个方法(lock\unlock)去夹住需要同步的代码==——注意unlock确保一定要执行
- 创建的lock实例必须要保证多个线程用同一个（static）；
- ` private static final ReentrantLock lock = new ReentrantLock();`
- 由于Lock是一个接口，所以可以提供更多的实现类

###线程间通信
- ![image-20231015103357974](../../../GitT/Pic/image-20231015103357974.png)

- 三个方法必须在同步中使用；三个方法的调用者必须是同步监视器的调用者（一致）
- wait到达指定时间自动结束阻塞or被唤醒

###JDK5.0新增的创建方式：
1. 实现Callable方法
	- 与Runnable不同的是，其中的call方法可以有返回值

2. 开发中常用线程池：
	- ![image-20231015140855167](../../../GitT/Pic/image-20231015140855167.png)
	- 可以实现资源的重复利用（不用一直创建销毁）；对资源进行管理
###ThreadLocal类：（从题目了解）
- `public class ThreadLocal<T>`可以看出其不继承于thread,没有实现Runnable接口
- 为每一个线程都维护了自己独有的变量拷贝，每个线程都有自己独立的一个变量。作用在于**数据的独立性**；保证了各个线程间数据安全，不会被其他线程访问和破坏——==因为每个线程都有一个线程局部变量的独立副本，可以改变这个副本从而不影响其他线程==
- 采用哈希表的方式提供变量的副本。