# JDK'sNew C
## JDK8:Lambda
### Lambda作用：
- 提供一种简洁的方式来==实现**只有一个抽象方法**的接口==，这种接口被称为**函数式接口**（Functional Interface）；特别是作用在匿名内部类当中
- lambda表达式作为了接口实例化的**对象**；*等号右边剩下形参列表和方法体，其实就是一个匿名函数* （注意，形参列表和方法体之间有->符号）
### 语法格式：
- -> 箭头用来链接参数和lambda体
1.  无参，无返回值：

```java
Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love u");
            }
        };

        r1.run();

        System.out.println("********************");
        Runnable r2 = () -> {
            System.out.println("I love u");
        };
```
2. 需要一个参数，无返回值

```java
Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("xxxx");
        
        Consumer<String> con1 = (String s) ->{
            System.out.println(s);
        };
        con1.accept("xxxxx");
```
3. 数据类型可以省略，因为可以由编译器推断得出

```java
        Consumer<String> con3 = (s) ->{
            System.out.println(s);
        };//因为前面已经有了可以推断出，所以不用声明形参为String
```
4. 如果只有一个参数，参数的小括号可以省略

```java
 Consumer<String> con3 = s ->{
            System.out.println(s);
        };
```
5. 需要两个及以上的参数，有返回值

```java
Comparator<Integer> com1 =(x1,x2) ->{
            return x1.compareTo(x2);
        };
        System.out.println(com1.compare(12,13));
```
6. 当lambda体==一条语句时，return与大括号都可以省略掉==

```java
Comparator<Integer> com2 = (x1,x2) -> x1.compareTo(x2);
```
### 四个基本的函数式接口：

<img src="./../Pic/image-20231102193617279.png" alt="image-20231102193617279" style="zoom:50%;" />

## 方法引用：
- 是进一步的lambda表达式，满足一定条件时（如：方法体中必须得只有一条语句），可以使用方法（构造器）引用来代替lambda表达式
- 格式：类（对象） :: 方法名；例如 类 :: 静态方法   对象::实例方法
- 注意最后*使用这个实例化的对象时调用其重写的方法*；==方法引用更关注重写方法的**方法体发生了什么**==
### 情况一对象：
- 对象 :: 实例方法
- 条件：函数式接口中的抽象方法a（外面的方法）与其内部实现时调用的对象的某个方法b的**形参和返回值类型都一致**。可以考虑吧使用方法b对方法a进行一个覆盖和替换。
```java
Supplyer<T> sp = emp :: getName;
```
### 情况二 类静态：
- 类::静态方法
- 与上面几乎相同的条件，只是把对象换成了类，方法换成了静态方法

```java
Function<Double,Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double,Long> fun2 = Math :: round;
        fun2.apply(2.0);
```
### 情况三 
- 类名::实例方法
- 条件苛刻：抽象方法a与其内部实现时调用的某个方法b的返回值类型相同，a有n个参数，b有n-1个参数。a的第一个参数作为方法b的调用者，后n-1个参数与b的参数类型相同。
- 虽然b是非静态的方法，需要对象调用，但是形式上，写出对象所属的类即可。
```java
BiPredicate<String,String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };
        
        BiPredicate<String,String> biPredicate1 = String::equals;//类名::非静态方法
```
### 构造器引用：
