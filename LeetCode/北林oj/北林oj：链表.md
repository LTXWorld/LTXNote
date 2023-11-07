# 北林oj：链表

## 一、递归单链表求最大值251

### 题目要求：

```java
* 利用单链表表示一个整数序列，利用递归的方法求出单链表中整数的最大值。
* 多组数据，每组数据有两行，第一行为链表的长度n，第二行为链表的n个元素（元素之间用空格分隔）。
* 当n=0时输入结束。
* 对于每组数据分别输出一行，输出每个链表的最大值。
```

### 第一想法

对于这个递归，没想到好的处理办法。并且对于链表的操作也有些生疏。

### 正解

首先，在链表这个类中，你得提供addNode方法来尾插建立链表；其次这个递归的思路是：**每次与自己的下一个节点值进行比较，并返回二者中的最大值**，然后根据递归的结束条件，依次地往后进行比较，直到达到结束条件为止。

1. 传入参数：某个链表节点
2. 结束条件：节点的下一个为空
3. 单次递归操作：与下一个节点的值进行比较

还要注意的是，由于题目给出多组数据，所以每进行一组数据的处理，其实就要去新建一个链表。

### 代码实现
```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 利用单链表表示一个整数序列，利用递归的方法求出单链表中整数的最大值。
 * 多组数据，每组数据有两行，第一行为链表的长度n，第二行为链表的n个元素（元素之间用空格分隔）。
 * 当n=0时输入结束。
 * 对于每组数据分别输出一行，输出每个链表的最大值。
 *
 */
public class SingleMax {
    public static void main(String[] args) {
        //怎么递归地找出最大值呢——递归三要素：传参是什么？结束条件、单次递归怎么进行
        Scanner sc = new Scanner(System.in);
        //
        while (true){
            int n =sc.nextInt();
            if (n == 0){
                break;
            }
            ListNode listNode = new ListNode();//新建链表
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                listNode.addNode(value);//填充链表
            }
            int max = listNode.GetMax();
            System.out.println(max);
        }
    }
}
class Node{
    Node next;
    int value;

    public Node(int value) {
        this.next = null;
        this.value = value;
    }
}
//链表
class ListNode{
    int size;
    Node head;

    public ListNode() {
        this.size = 0;
        this.head = new Node(0);//头结点
    }
    //提供尾插法
    public void addNode(int value){
        if (head == null){
            head = new Node(value);
        }else{
            Node node = head;
            while (node.next != null){
                node = node.next;//走到尾巴上准备尾插
            }
            node.next = new Node(value);
        }
    }
    //这个无参的方法对主要的方法进行调用，在有参方法中完成递归
    public int GetMax(){
        if (head == null){
            return Integer.MIN_VALUE;
        }else {
            return GetMax(head);
        }
    }
    //递归方法，主题思路是与下一个节点进行大小的比较。不断地与自己的下一个比较。
    public int GetMax(Node node){
        //如果下一个没有节点，则返回自己的值
        if (node.next == null){
            return node.value;
        }else {
            int max = GetMax(node.next);//每次当前节点都与下一个节点进行比较得到二者中的最大值
            return node.value > max ? node.value : max;
        }
    }
}

```

## 二、一趟遍历求链表中的最大值

### 题目要求：

利用单链表表示一个整数序列，通过一趟遍历在单链表中确定值最大的结点。

其他要求与上题一样。

### 第一想法：

一趟遍历，那不就先设一个工作指针以及最大值，然后往后遍历遇到大的更新最大值，最后返回最大值不就完了？

### 正解：

确实如我想的那样，但是在编写代码时特别是最重要的程序时，出现了问题。应该直接指定最大值为头结点的值，然后再让工作指针指向头结点的下一个，逐渐向后遍历；这样这个方法也不需要传入参数了。

### 代码实现：

```java
//其他操作跟上面代码一致
    public int OneMatch(){
        if (head == null){
            return Integer.MIN_VALUE;
        }
        int max = head.value;
        Node2 node2 = head.next;
        while (node2 != null){
            if (node2.value > max){
                max = node2.value;
            }
            node2 = node2.next;
        }
        return max;
    }
```

## 三、链表的逆转

### 题目要求：

利用单链表表示一个整数序列，通过一趟遍历，将单链表中所有结点的链接方向逆转。要求空间复杂度为O(1)。

对于每组数据分别输出一行，逆序输出链表中的元素，元素之间用空格分隔。

### 第一想法：

头插法，没什么好说的。但是在输出的时候遇到问题，输出你还得遍历建好的链表，但是链表怎么遍历输出呢？

### 正解：

我理解错了题目的意思，空间复杂度为1，你正常尾插法空间复杂度也是1啊，所以这道题意思就是力扣做过的翻转链表。

翻转链表不使用额外空间的经典操作就是将指针甩到前面去，核心在于三个指针操作，记得保存下一个要操作的节点。具体见代码随想录那一节。[[代码随想录 (programmercarl.com)](https://programmercarl.com/0206.翻转链表.html)]()

### 代码实现：

虽然还是wrong，但是我觉得这样写已经很不错了。注意其中的方法写法。（更新头结点，换行输出等等）
```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 利用单链表表示一个整数序列，通过一趟遍历，将单链表中所有结点的链接方向逆转。
 * 要求空间复杂度为O(1)。
 */
public class ReverseAll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            ListNode3 listNode3 = new ListNode3();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                listNode3.addNode3(value);
            }
            listNode3.reverseList(listNode3.head);
            listNode3.printInfo();
        }
    }

}
class Node3{
    Node3 next;
    int value;

    public Node3( int value) {
        this.next = null;
        this.value = value;
    }
}
class ListNode3{
    Node3 head;

    public ListNode3() {
        this.head = null;
    }

    public void addNode3(int value){
        if (head == null){
            head = new Node3(value);
        }else{
            Node3 node3 = head;
            while (node3.next != null){
                node3 = node3.next;
            }
            node3.next = new Node3(value);
        }
    }

    //翻转链表
    public void reverseList(Node3 head){
        Node3 pre = null;
        Node3 cur = head;
        Node3 temp ;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;//将当前节点的next往前甩
            pre = cur;
            cur = temp;
        }
        this.head = pre;//这里要更新头结点，注意使用this
    }
    //
    // 打印链表
    public void printInfo() {
        Node3 node3 = head;
        while (node3 != null) {
            System.out.print(node3.value + " ");
            node3 = node3.next;
        }
        System.out.println();
    }

}


```

## 四、两个递增有序序列的合并

### 题目要求：

给定两个递增的整数序列A和B，利用链表表示序列A和B，将A和B合并为一个递增的有序序列C，序列C不允许有重复的数据。要求空间复杂度为O(1)。

多组数据，每组数据有三行，第一行为序列A和B的长度n和m，第二行为序列A的n个元素，第三行为序列B的m个元素（元素之间用空格分隔）。n=0且m=0时输入结束。

### 第一想法

两个指针去走，去比较。

```
我的想法是在每个链表头设置指针，指向的元素进行比较，大的插在小的后面。
* 如果相等，选择一个指针往后走，另一个不动。这样可以完成去重
* 具体怎么比较：如果发现一方大，小的指针继续往后走，直到不小于对方才停下来
* 然后将刚才大的那方插入到停下来的位置前。谁插入的谁往后走，继续去进行比较。
```

但是问题是这个merge函数我真难写出来，罢了，以后找个制造业进去躺吧，实力太烂了。

### 正解：

在merge函数中有许多地方需要注意，它里面有很多条件需要判断，很烦。

样例过了，没ac。

### 代码实现：
```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class MergeTwoASC {
    public static void main(String[] args) {
        /**
         * 我的想法是在每个链表头设置指针，指向的元素进行比较，大的插在小的后面。
         * 如果相等，选择一个指针往后走，另一个不动。这样可以完成去重
         * 具体怎么比较：如果发现一方大，小的指针继续往后走，直到不小于对方才停下来
         * 然后将刚才大的那方插入到停下来的位置前。谁插入的谁往后走，继续去进行比较。
         */
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            int m =sc.nextInt();
            if (n == 0 && m == 0){
                break;
            }
            ListNode4 listNode4 = new ListNode4();
            ListNode4 listNode5 = new ListNode4();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                listNode4.addTrail(value);
            }
            for (int i = 0; i < m; i++) {
                int value = sc.nextInt();
                listNode5.addTrail(value);
            }
            listNode4.merge(listNode5);
            listNode4.printInfo();
        }

    }



}
class Node4{
    Node4 next;
    int value;

    public Node4(int value) {
        this.value = value;
        this.next = null;
    }
}
class ListNode4{
    Node4 head;

    public ListNode4() {
        this.head = null;
    }
    //尾插法
    public void addTrail(int value){
        if (head == null){
            head = new Node4(value);
        }else {
            Node4 node4 = head;
            while (node4.next != null){
                node4 = node4.next;
            }
            node4.next = new Node4(value);
        }
    }
    //合并方法，只需要传入一个链表，最终成型的链表是cur1所在的
    public void merge(ListNode4 list02){
        Node4 cur1 = head,cur2 = list02.head,pre = null;
        while (cur1 != null && cur2 != null){
            if (cur1.value < cur2.value){
                pre = cur1;
                cur1 = cur1.next;
                //这里跟我想的很像，就是小了就先一直往后走
            }else if (cur1.value > cur2.value){//发现大的了才去将原来那个大的插入
                Node4 tmp = cur2.next;//准备对cur2动手就得保存位置
                cur2.next = cur1;
                if (pre == null){
                    head = cur2;
                }else {
                    pre.next = cur2;//pre此时指向的是要插入节点的前一个位置
                }
                pre = cur2;
                cur2 = tmp;
            }else {
                //相等的情况都往后走？
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        //出这个while循环，此时走下面意味着cur1=null
        if (cur2 != null){
            if (pre == null){
                head = cur2;
            }else {
                pre.next = cur2;
            }
        }
    }
    //输出方法
    public void printInfo(){
        Node4 cur = head;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

```

## 五、基于链表的两个集合的交集

### 题目要求：

给定两个递增的整数集合A和B，分别用链表表示集合A和B，求出A和B的交集，并存放在A中。要求空间复杂度为O(1)。

```
5 5
1 3 5 7 9
1 2 3 4 5
3 4
1 2 5
2 4 5 6
0 0
```

输出样例 1

```html
1 3 5
2 5
```

### 第一想法

一样的思路，两个指针去遍历——

能用哈希表记录某个关键字的出现次数吗？这样不符合题意。

### 正解：

答案意思是比较值，如果某个小那么小的就不会重复，需要删除。（因为都是递增的）但是不对啊，此题搞不出来。

### 代码实现：

## 252 递归地求链表的结点个数

### 题目要求

利用单链表表示一个整数序列，利用递归的方法计算单链表中结点的个数。

### 第一想法

仿照251题，设计方法，如果当前结点下一个不为空，就继续调用这个方法，直到下一个结点为空。

递归三要素：结束条件是下一个为空，传参：传一个当前结点，单次递归执行：个数++，只要不为空返回个数？

### 正解

对于个数如何计算没有想明白，当结点为空时返回0；结点不为空就返回 1 + 递归？

但是为什么最后我的代码会多出来一个值呢？——因为我没从头结点开始。

### 代码实现

```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class OneMatchNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            ListNode6 listNode6 = new ListNode6();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                listNode6.add(value);
            }
            System.out.println(listNode6.GetNum(listNode6.head) - 1);
        }
    }
}
class Node6{
    Node6 next;
    int value;

    public Node6(int value) {
        this.next = null;
        this.value = value;
    }
}
class ListNode6{
    Node6 head;

    public ListNode6() {
        this.head = null;
    }
    //
    public void add(int value){
        if (head == null){
            head = new Node6(value);
        }
        Node6 n = head;
        while (n.next != null){
            n = n.next;
        }
        n.next = new Node6(value);
    }
    //
    public int GetNum(Node6 head){
        if (head == null){
            return 0;
        }
        return 1 + GetNum(head.next);
    }
}
```

## 253递归求单链表平均值

### 题目要求：

如题所示

### 第一想法：

原本以为要求平均值单独写一个递归的算法，后来发现自己想多了。直接调用上面写过的求个数，以及加一个递归求总和即可。

最后记得类型转换，注意：return (double) sum/num 和 return (double) (sum/num)不一样。前者类型转换优先，将sum先转了；后者计算优先，会进行截断。

### 代码实现：

```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class OneMatchAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            ListNode7 listNode7 = new ListNode7();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                listNode7.addNode(value);
            }
            double aver = listNode7.getAver(listNode7.head);
            System.out.printf("%.2f\n",aver);
        }
    }
}
class Node7{
    Node7 next;
    int value;

    public Node7(int value) {
        this.next = null;
        this.value = value;
    }
}
class ListNode7{
    Node7 head;

    public ListNode7() {
        this.head = null;
    }
    //
    public void addNode(int value){
        if (head == null){
            head = new Node7(value);
        }else{
            Node7 node = head;
            while (node.next != null){
                node = node.next;//走到尾巴上准备尾插
            }
            node.next = new Node7(value);
        }
    }
    //
//    public double getAver(){
//        if (head == null){
//            return 0;
//        }else {
//            return getAver();
//        }
//    }
    //求平均值，先求总和和个数
    public int getSum(Node7 head){
        if (head == null){
            return 0;
        }
        return head.value + getSum(head.next);
    }
    //
    public int getNums(Node7 head){
        if (head == null){
            return 0;
        }
        return 1 + getNums(head.next);
    }
    public double getAver(Node7 head){
        if (head == null){
            return 0;
        }
        int sum = getSum(head);
        int num = getNums(head);
        return (double) sum/num;
    }
}
```

## 412 奇偶链表的分割

### 题目要求

给定一个单链表，把所有的奇数结点和偶数结点分别排在一起，重新链成一个新链表。请注意，这里的奇数结点和偶数结点指的是结点编号的奇偶性，而不是结点的值的奇偶性。

要求：空间复杂度应为 O(1)，时间复杂度应为 O(n)，n 为链表结点总数。

### 第一想法

这里要组成新的链表并且空间复杂度为1，那就要在链表本身进行指针的操作。但是这样跳着去连，中间的偶数结点怎么保存呢？我觉得两个方向的操作应该同步进行，一个指针用来连奇数，一个用来连偶数，最后把偶数的头连接在奇数的后面完成。

这是使用递归还是一个for循环进行呢？

### 正解：

- 关于开始的思路，我想的没问题。注意要设置三个结点，关键的一个偶数头结点用来保存偶链表的头部等着最后的接入。
- 但是最后自己的疑问发现了问题所在：如何进行遍历？准确的说条件是什么——使用了while循环判断偶节点和其后一个结点不为空。

### 代码实现

```java
package com.luluedu.beilin.Lian;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 给定一个单链表，把所有的奇数结点和偶数结点分别排在一起，重新链成一个新链表。
 * 这里的奇数结点和偶数结点指的是结点编号的奇偶性，而不是结点的值的奇偶性。
 * 要求：空间复杂度应为 O(1)，时间复杂度应为 O(n)，n 为链表结点总数。
 */
public class JiOuMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            //建立链表
            ListNodeO list = new ListNodeO();
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                list.add(value);
            }
            //进行分割并输出
            NodeO head2 = list.OddEven(list.head);
            list.printInfo(head2);
        }
    }
}
class NodeO{
    NodeO next;
    int value;

    public NodeO(int value) {
        this.next = null;
        this.value = value;
    }
}
class ListNodeO{
    NodeO head;

    public ListNodeO() {
        this.head = null;
    }
    //尾插法建立链表
    public void add(int value){
        if (head == null){
            head = new NodeO(value);
        }else {
            NodeO cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new NodeO(value);
        }
    }
    //提供分割奇偶链表的方法
    public NodeO OddEven(NodeO head){
        if (head == null || head.next == null){
            return head;
        }
        //设置三个指针
        NodeO odd = head;
        NodeO even = head.next;
        NodeO evenhead = even;//最后要把偶数的头结点给接在奇数链表的尾巴后面
        while (even != null && even.next != null){//注意这里的条件是与的关系，因为第三步odd.next会指向后面的后面
            odd.next = even.next;
            odd = odd.next;//更新工作指针
            even.next = odd.next;
            even = even.next;//更新
        }
        //将两个链表合二为一
        odd.next = evenhead;
        return head;//最后返回整个链表最初的头结点，其实也就是奇数第一个结点
    }
    //再给一个输出方法
    public void printInfo(NodeO head){
        NodeO cur = head;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

```

## 414 删除倒数第k个结点

### 题目要求：

利用单链表表示一个整数序列，请设计算法通过一趟遍历，删除链表中的倒数第k个结点

对于每组数据分别输出一行，输出删除后链表的所有元素。如果删除后，链表删除为空，输出The LinkList is Empty !。

### 正解：

- 还要求一趟遍历，这个题就必须使用快慢指针了，让快指针先走以至于一起走的时候慢指针走到删除的结点前一个位置。（注意删除操作的核心就是找到前一个位置）。
- 还有一个细节，如果链表删完了就得输出信息。对了，如果删除位置不对呢？好像没说，默认删除位置是存在的？
- 先接收，创建链表、提供快慢删除法（其中条件判断）、最后提供输出信息方法。

### 代码实现：
- 怎么又是过了案例没ac
```java
package com.luluedu.beilin.Lian;

import javax.swing.tree.TreeNode;
import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class DeleteBack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            ListNodeDe list = new ListNodeDe();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            //
            int k = sc.nextInt();
            NodeDe result = list.Delete(list.head, k);
            list.printInfo(result);
        }
    }
}
class NodeDe{
    NodeDe next;
    int value;

    public NodeDe(int value) {
        this.next = null;
        this.value = value;
    }
}
class ListNodeDe{
    NodeDe head;

    public ListNodeDe() {
        this.head = null;
    }
    //
    public void add(int value){
        if (head == null){
            head = new NodeDe(value);
        }else {
            NodeDe cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = new NodeDe(value);
        }
    }

    /**
     *
     * @param head 待删除链表头结点
     * @param n 倒数第n个位置
     * @return 返回头结点，利用虚拟结点下一个进行返回。
     */
    public NodeDe Delete(NodeDe head,int n){
        NodeDe dummyHead = new NodeDe(-1);
        dummyHead.next = head;
        NodeDe fast = dummyHead;
        NodeDe slow = dummyHead;
        //快指针向后走n+1步
        n ++;
        for (int i = 0; i < n; i++) {
            //如果n+1步比链表长度还长了
            if (fast == null){
                return dummyHead.next;
            }
            fast = fast.next;
        }
        while (fast != null){
            //一起往后走
            fast = fast.next;
            slow = slow.next;
        }
        //走到待删除位置前一个位置
        slow.next = slow.next.next;
        return dummyHead.next;
    }
    //
    public void printInfo(NodeDe head){
        NodeDe cur = head;
        if (head == null){
            System.out.println("The LinkList is Empty !");
        }
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
```