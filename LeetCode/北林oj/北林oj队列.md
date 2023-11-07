# 北林oj队列

## 246 基于循环链表的入队出队

### 题目要求：

用带头结点的循环链表表示队列，并且只设一个指针指向队尾元素结点（不设头指针）。实现该队列的入队出队以及判断队列是否为空操作。

多组数据，每组数据有两行。第一行为两个整数n和m，n表示入队序列A的长度（n个数依次连续入队，中间没有出队的情况），m表示出队序列B的元素数量（m个数依次连续出队，中间没有入队的情况）。第二行为序列A（空格分隔的n个整数）。当n和m都等于0时，输入结束。

对应每组数据输出一行。每行包括m+1个整数，前m个数代表出队序列B的各个整数，最后一个整数表示队列是否为空，队列为空输出0，不为空输出1。整数之间用空格分隔。

### 第一想法

给了头节点和尾指针，尾插法用来入队，并且同时移动尾指针。注意题目要求循环队列，那么最后一个节点的next指向头结点——即尾指针的下一个指向头结点，出队的话得找到头，让头结点直接指向下下一个节点。然后需要保存这个出队的值进行输出。

条件是下下一个节点不能为空。

### 正解

这道题我按照惯性思路去设计链表，但是重要操作应该是在主函数完成。

- 这道题最色的地方在于他说的头结点不是我想的那个虚拟头结点
- 并且完全不是以前申请链表的那一套操作，是申请队列。
- 循环链表的插入操作——**先将自己与头连接起来，再让原来的尾巴指向自己，最后移动尾指针**。
- 删除操作：直接把tail.next这个链条甩到head的下一个上，完成了删除头结点。
- 最后它把出队的元素全部保存在了数组中，方便输出。

### 代码实现
```java
package com.luluedu.beilin.queue_;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class DL02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n==0 && m==0){
                break;
            }
            Queue queue = new Queue();
            for (int i = 0; i < n; i++) {
                queue.enqueue(sc.nextInt());
            }
            int[] arr = new int[m];//用来存放要输出的东西
            for (int i = 0; i < m; i++) {
                arr[i] = queue.dequeue();
            }
            System.out.print(arr[0]);//这里为什么先输出了一个？因为后面都是加空格的，第一个前面没有空格
            for (int i = 1; i < m; i++) {
                System.out.print(" " + arr[i]);
            }
            if (queue.isEmpty()){
                System.out.println(" 0");//注意空格
            }else
                System.out.println(" 1");
        }
    }
}
class Node02{
    public int data;
    public Node02 next;

    public Node02(int data) {
        this.data = data;
        this.next = null;
    }
}
//队列
class Queue{
    private Node02 tail;//尾指针

    public Queue(){
        this.tail = null;//新建队列尾指针为空？
    }
    //
    public boolean isEmpty(){
        return tail == null;//
    }
    //
    public void enqueue(int data){
        Node02 node = new Node02(data);
        if (isEmpty()){//如果链表为空，新来的节点作为头结点？
            node.next = node;
            tail = node;
        }else {//新加入的节点得先指向头结点，然后让原来的尾节点指向它，最后更改尾指针
            node.next = tail.next;//形成循环链表
            tail.next = node;
            tail = node;
        }
    }
    //删除
    public int dequeue(){
        if (isEmpty()){
            throw new NoSuchElementException("Empty");
        }
        Node02 head = tail.next;
        if (head == tail){
            tail = null;//意味着队列只剩下头结点了，空队
        }else {
            tail.next = head.next;//删除头结点
        }
        return head.data;
    }
}

```

## 247 附加判定标志的循环队列基本操作

### 题目要求：

假设以数组Q[m]存放循环队列中的元素, 同时设置一个标志tag，以tag== 0和tag == 1来区别在队头指针(front)和队尾指针(rear)相等时，队列状态为“空”还是“满”。试编写与此结构相应的插入(enqueue)和删除(dlqueue)算法。

多组数据，每组数据有两行。第一行为一个整数n，n表示入队序列A的长度（n个数依次连续入队，中间没有出队的情况），第二行为序列A（空格分隔的n个整数）。当n=0时，输入结束。

对应每组数据输出一行。依次输出队列中所有的整数，每两个整数之间用空格分隔。

### 第一想法：

循环队列怎么实现的？这可不等于上面的循环链表。

- 队列逻辑上形成一个环状，利用取余操作实现。
- **队空、出队、入队指针的变化**——+1取模、队列长度
- 如何判断队满——原则是是牺牲一个空间；**本题使用一个tag判断。tag为0队空，tag为1队满。**

### 正解：
复习数据结构。3月20日开始全面复习408
### 代码实现

```java
package com.luluedu.beilin.queue_;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class CircleQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            //入队
            CQueue cQueue = new CQueue(n);
            for (int i = 0; i < n; i++) {
                cQueue.enqueue(sc.nextInt());
            }
            //出队
            StringBuilder sb = new StringBuilder();
            while (! cQueue.isEmpty()){
                sb.append(cQueue.dlqueue()).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
class CQueue{
    private int[] queue;
    private int front;
    private int rear;
    private int tag;

    //初始化队列，新建一个数组保存队列
    public CQueue(int size) {
        queue = new int[size];
        front = rear = 0;
        tag = 0;
    }

    //判断是否为空
    public boolean isEmpty(){
        return rear == front && tag == 0;
    }
    //判断是否满了
    public boolean isFull(){
        return rear == front && tag ==1;
    }
    //入队
    public void enqueue(int x){
        if (isFull()){
            System.out.println("已满");
            return ;
        }else {
            //入队操作，数据结构知识
            queue[rear] = x;
            rear = (rear + 1) % queue.length;
            if (front == rear){//注意这里的判断不能少，入队万一满了呢
                tag = 1;
            }
        }
    }
    //出队
    public int dlqueue(){
        if (isEmpty()){
            System.out.println("队空");
            return -1;
        }else {
            int x = queue[front];
            front = (front + 1) % queue.length;
            if (front == rear){
                tag = 0;
            }
            return x;//将出队元素返回
        }
    }
}
```

## 248 双端队列循环队列的实现

### 题目要求：

如果允许在循环队列的两端都可以进行插入和删除操作。构造一个循环队列，实现从队头入队，从队尾出队并输出。约定从队头入队时向下标小的方向发展，从队尾入队时则向下标大的方向发展。

多组数据，每组数据有两行。第一行为一个整数n，n表示入队序列A的长度（n个数依次连续入队，中间没有出队的情况），第二行为序列A（空格分隔的n个整数）。当n等于0时，输入结束。

### 第一想法：

看题目要求，本质是循环队列。但是循环队列怎么实现双端队列呢？队头入队还向下标小的地方进行？

队列这个类，初始front指向数组的最后，rear指向数组头部，但是怎么判断你是从队头入还是从队尾入队呢？

### 正解：

感觉就是把front和rear的位置互换，然后把两个位置上的操作都来一遍，但是为什么不对应该是没有理解题目的要求。

不过这个操作学会还是很有用的。

### 代码实现：

## 