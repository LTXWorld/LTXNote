# 北林oj数据结构题目总结1

## 顺序表：

### 回顾：

在做最贵图书以及最喜欢图书顺序表两道题目时，回顾一下思路。

#### 输入输出：

- 首先对于java程序的输入输出怎么弄，特别是输入。有了这个sc对象之后，可以用它的自带方法去接收用户的输入值。并且只需要在程序开始时声明一次即可。
 ```java
 Scanner sc = new Scanner(System.in)//注意括号里面的内容
  sc.next();//接收字符串
  sc.nextInt(); //接收整数类型
 ```

- 输出也要注意题目的条件，比如用空格分开，保留两位小数。在这里我选择了去Book类当中使用toString方法来进行输出。并且保留两位小数他用的是**String.format**。（这里其实没有看懂为什么）
```java
+String.format("%.2f",price);
```

#### 对信息进行填充：

- 个人认为将Book写作类，然后创建Book数组去存储这些实例对象，最终在for循环或者while循环当中去填充。
- 同时，填充时采用新建临时属性的方式暂存输入信息，最后再新建对象把他们都放在数组当中。
```java
BookM[] book05s = new BookM[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            book05s[i] = new BookM(id,name,price);
        }
```

#### 抵消换行符操作：（问题）

其实这一步我没怎么看懂，说是在nextInt接收之后会影响字符串前面的\，所以这一步有待考虑。
```java
sc.nextLine();
```

#### 增强for循环：

可以用它来方便地取到数组当中的元素，注意数据类型要一样。

```java
for(Book book : booklist){
	....
}
```

#### 思路问题：

- 可以把一些关键的方法写成一个独立的方法，更加oop一些。（这些**方法在写的时候，它们的返回类型很重要**，不是单纯的void int 什么的，因为往往你会返回一个操作过的数组等等。）
- 在没有具体要求的前提下，可以自己创建数组空间去保存一些特殊的对象、值。

### 顺序表插入删除：

- 使用到了Arraylist类创建其对象booklist保存图书信息，目的是使用Arraylist类自带的插入删除方法
```java
//使用list保存图书对象信息。
ArrayList<BookI> bookList = new ArrayList<>(); 
bookList.add(bookI);
//插入删除
bookList.add(index - 1,bookInsert);
bookD.remove(indexDelete - 1);
//但是严谨起见，我们不使用这个remove，可以从删除位置开始把后面的元素全部往前移一位；插入方法从最后开始往后移一位。
```
- 并且在接收传入的信息时，为了**保证格式的正确**（题目要求是一行为一本书信息，用空格分开）使用了split划分，划分后结果为一群字符串，将其保存在info数组里面。
```java
String[] info = sc.nextLine().split(" ");
String id = info[0];
String name = info[1];
double price = Double.parseDouble(info[2]);//这里也用了parse方法接收价格，为了防止溢出。
```

### 顺序表的去重

- 去重的思路很独特，我原以为使用一个方法就可以完成找到对应图书并使用remove方法将重复图书删除，但是题解使用的是新思路。
- 先创建一个空的新的Arraylist集合，用来保存去重后的结果，然后对于原数组进行遍历，遍历过程中去判断**某个编号是否在新集合里面存在**，如果不存在就将这本书加入到新数组当中（很好地做到了题目要求的**留下第一个出现的图书**）
- 判断是否存在的方法就蛮简单了，注意书号是字符串类型使用equals判断是否相等。
```java
//首先去重，在内部调用存在方法
public static ArrayList<BookRep> RemoveRepeat(ArrayList<BookRep> bookReps){
        ArrayList<BookRep> bookResult = new ArrayList<>();//创建一个新数组来保存最终去重后的结果
        for (BookRep bookRep : bookReps){
            if(! ContainRepeat(bookResult,bookRep.getId())){
                //注意这句话意思是在新创建的数组里面去重，这样会导致刚开始所有不一样的进来，当有一样的进来时if内为false
                bookResult.add(bookRep);//当书号不一样时，我们才把原来数组里面的元素加入到新数组当中
            }//书号一样就不操作，不把书籍加入新数组就行
        }
        return bookResult;
    }

//存在与否。
public static boolean ContainRepeat(ArrayList<BookRep> bookReps,String id){
        for(BookRep bookRep : bookReps){
            if(bookRep.getId().equals(id)) {
                return true;
            }
        }
        return false;//找了一圈都不存在等于这个书号的，就返回false
    }
```

## 链表：

### 创建

#### 回顾思路

- 最标准的写法在main01当中，但是像计算平均价格，头插等方法我们可以不用大费周章，**可以直接声明head，trail两个指针来完成构建。**注意这样写的时候对于**图书类里面要多加一个next指针属性。**
- 在MainLian07中体现的尤为明显，都能Ac

- 首先链表与顺序表不同，在创建过程中我们需要有图书类（老生常谈）、要有单一节点类，数据域，指针（注意二者的数据类型）以及构造器（**传参只需要传数据域即可，因为每次创建一个新的节点它的next指针暂时为空**）并且这里我们把图书对象当作数据域的内容。里面的**get set方法用来设置后续指针与判断后面是否为空**。
```java
class listNode{
    private Book01 data;//数据域注意数据类型是Book1
    private listNode next;//指针next注意数据类型是listNode
    //注意链表节点的构造器只传入数据，指针初始设置为空
    public listNode(Book01 data) {
        this.data = data;
        this.next = null;
    }
    //其中get set方法也只有对指针进行set？
    public Book01 getData() {
        return data;
    }
    //这一步其实意思是看后面还有没有节点
    public listNode getNext() {
        return next;
    }
    //这一步其实意思是向后走
    public void setNext(listNode next) {
        this.next = next;
    }
}
```
- 其次，定义一个链表类，用来对整个链表进行操作。其中属性有头节点（利于操作）、链表长度（题目要求返回）。并且在类里面提供了尾插法用来插入，输出信息方法用来返回输出。在这些方法中要注意临时指针的使用。
```java
class BookList01{
    //设置两个属性：头节点方便操作，链表长度
    private listNode head;
    private int size;
    //构造器初始化链表

    public BookList01() {//注意无参构造器
        this.head = new listNode(null);//注意这里头节点是new出来的一个新节点，利用了节点的构造器传入data为空
        this.size = 0;
    }
    //链表信息的接收填充要选择合理的插入方法，头插法或尾插法，不像顺序表那样简单地接收，所以定义一个方法尾插
    //这里进行尾插，传入data即可(data代表着一本图书的全部信息）
    public void TrailAdd(Book01 data){
        listNode Node = new listNode(data);
        //尾插法，需要一个工作指针指向头节点，当头节点的下一个不为空时向后走，直到为空则插入
        //插入和向后走其实都在节点类中set get方法中体现
        listNode p = head;
        while (p.getNext() != null){
            p = p.getNext();
        }
        //为空了插入
        p.setNext(Node);
        size ++;//注意别忘了对规模进行处理，因为最后要输出规模的
    }
    //再提供一个输出信息的方法
    public void printInfo(){
        listNode p = head.getNext();
        System.out.println(size);
        //开始进行输出信息
        while (p != null){
            Book01 book01 = p.getData();//得到图书对象，图书对象里面包含了三个信息
            System.out.printf("%s %s %.2f",book01.getId(),book01.getName(),book01.getPrice());
            p = p.getNext();
        }
    }
}
```
- 最后在主函数中，接收输入一样的套路，多了新建一个链表对象。把输入信息放到图书对象当中，然后再把图书对象利用尾插法插入到整个链表对象当中完成链表的填充。
```java
Book01 book01 = new Book01(id, name, price);
bookList01.TrailAdd(book01);//尾插放入链表当中
```

### 排序

#### 方法一
- 如果直接调用java中的集合与相对应的排序方法，是可以通过的，LinkedList底层是双向链表。
```java
List<BookAppendix> books = new LinkedList<>();

//使用colletion集合里面的排序方法sort，对books集合进行排序，重写了compare方法。
Collections.sort(books, new Comparator<BookAppendix>() {
            @Override
            public int compare(BookAppendix o1, BookAppendix o2) {
                if(o1.price < o2.price){
                    return 1;//如果价格低就把它放到2的后面去
                }else if(o1.price > o2.price){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
//但是这样写你很明显发现没有使用到链表的知识，指针next，数据域什么的。        
```
#### 方法二：
- 也没有声明链表类等类，直接在主方法中创建链表时利用头节点完成。从这个方法来看我觉得反倒是最整体的，因为它确实使用到了指针这个概念，**只是声明指针在定义book类时已经声明**。
```java
class BookOrder{
    private String id;
    private String name;
    private double price;
    public BookOrder next;//可以这样声明next指针吗？}
  //边插入边排序
if(head == null){
  head = bookOrder;
            }else{
                //head不为空时表示链表中是有节点的
                BookOrder pre = null;//插入节点需要知道其位置的前一个节点
                BookOrder cur = head;
  							//出这个while循环就两个可能，当前cur为null或者你传进来的价格更高
                while (cur != null && cur.getPrice() > bookOrder.getPrice()){
                    //当你传进来的节点价格更低时，继续往后比较
                    pre = cur;
                    cur = cur.next;
                }
                //当你传入的价格更高时（条件2）
                if (pre == null){
                    head = bookOrder;
                }else{
                    //插入到两个中间了。或者cur为null了，直接插在后面。
                    pre.next = bookOrder;
                }
                bookOrder.next = cur;//当前插入的图书与之前比较的链接起来。
            }  
```
#### 方法三：传统

- 最为传统的方法，要声明链表类，节点类，图书类。并且在链表类当中提供插入（尾插）、排序、输出信息三个方法。在排序时采用最简单的冒泡排序，双层循环，每次可以排出一个最小值。
```java
Node2 cur = head;
        while(cur != null){
            Node2 nextNode = cur.next;
            while (nextNode != null){
                if(cur.data.getPrice() < nextNode.data.getPrice()){
                    //如果下一个价格比你高，你就得让位。最终里面的while循环把价格最低的推到最后了。
                    BookOrder2 temp = cur.data;
                    cur.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            //得到最高价格之后才把cur往后推一位
            cur = cur.next;
        }
```

### 修改

### 逆序

原本自己想的头插法会比较难，但是在这个接收输入的大前提下，好像还挺简单的。

```java
if(head == null){
    head = bookNode;
}else{
    bookNode.next = head;
	head = bookNOde;
}
```

## 数组

### 260 二维数组查重

#### 题目要求：

设二维数组a[1..m, 1..n] 含有m*n 个整数。写一个算法判断a中所有元素是否互不相同。

#### 第一想法：

二维数组本质是一个一维数组，每个空间又存了一个一维数组，JAVA中二维数组空间连续。怎么查重呢？

#### 正解：

我是傻逼，查重这玩意不就是记录出现次数吗，拿一个长的数组记录，数组值大于1的就有重复了。

并且这个数组也很巧妙，我们不一定非要确定下标去++值，**可以设置如果不重复就设置值为true，如果碰到值为true的就返回false；即这个数组是一个布尔类型的数组。（但是下标还是以原本值作为下标）**

#### 代码实现：

```java
package com.luluedu.beilin.Shunxu;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class DoubleDuplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (n == 0 && m ==0){
                break;
            }
            int[][] arr = new int[m][n];
            //填充数组
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            System.out.println(Duplicate(arr) ? "YES" : "NO");
        }
    }
    //查重方法：
    public static boolean Duplicate(int[][] arr){
        //取得二维数组的行数与列数
        int row = arr.length;
        int col = arr[0].length;
        boolean[] visited = new boolean[row*col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int num = arr[i][j];//num作为对应数组的下标
                if (visited[num]){
                    return true;//已经有了true说明重复
                }else {
                    visited[num] = true;
                }
            }
        }
        return false;//一圈遍历后都没有重复
    }
}


```

### 413 找出数组中和为目标值的两个数

#### 题目要求：

设计算法，找出数组中相加之和为目标值的两个数，并输出这两个数的下标。每组输入仅对应一种答案，相同的元素不能被重复利用。

多组数据，每组数据有三行，第一行为数组的大小n，第二行为n个元素（元素之间用空格分隔），第三行为目标值，当n=0时输入结束。

#### 第一想法：

这个题好像力扣里面有啊。我记得用双指针法可以解决。但这个不是一个有序的，前后双指针好像不太行。

#### 正解：

哦，这不就是两数之和吗。在哈希表里面，也勉强算是数组吧。我怎么对两数之和一点印象都没有了。

- 代码随想录给出的方法是使用哈希表，先去遍历数组，看哈希表中是否有当前值所需要的值，如果有就进行输出，如果没有的话就把当前值加入到哈希表中。
- 如果考试不让写HashMap的话，我是不是得先把数组里的所有值作为下标放入到一个新的数组中去，然后再依次地遍历数组去到新数组找相应下标值是否为1，找到返回，没找到继续找？

#### 代码实现：

发现输出的东西顺序不一样，结果是对的。原因是给结果数组赋值时顺序出错了。

```java
package com.luluedu.beilin.Shunxu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 设计算法，找出数组中相加之和为目标值的两个数，并输出这两个数的下标。
 * 每组输入仅对应一种答案，相同的元素不能被重复利用。
 * 多组数据，每组数据有三行，第一行为数组的大小n，第二行为n个元素（元素之间用空格分隔），
 * 第三行为目标值，当n=0时输入结束
 */
public class FindSumTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            //把第二行输入的元素全放到数组当中
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int[] result = twoSum(arr, target);
//            printInfo(result);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    /**
     *
     * @param arr 你所输入的数组
     * @param target 第三行输入的目标值
     * @return 返回一个下标数组，输出时再去遍历这个数组输出两个下标即可
     */
    public static int[] twoSum(int[] arr,int target){
        int[] result = new int[2];
        if (arr == null || arr.length ==0){
            return result;
        }
        //使用哈希表,key为值，value为下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp)){
                result[1] = i;
                result[0] = map.get(temp);
                return result;//应该立即返回结果
            }
            //没找到对应的key，将当前kv加入到map中来
            map.put(arr[i],i);
        }
        return new int[]{0,0};//实在找不到了
    }
//    public static void printInfo(int[] result){
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + " ");
//        }
//        System.out.println();
//    }
}


```