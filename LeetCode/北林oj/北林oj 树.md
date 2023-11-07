# 北林oj 树

## 263 基于二叉链表树相等的判断

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，按此方法创建两棵二叉树，然后编写递归算法判断这两棵树是否相等。

多组数据，每组数据有两行。每行为一个二叉树的先序序列（**序列中元素为‘0’时，表示该结点为空**）。当输入只有一个“0”时，输入结束。

### 第一想法

基于二叉链表的做法以前没有了解过。如果是数组的做法可以参照代码随想录章节先序遍历的递归实现。

### 正解：



### 代码实现

```JAVA
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class LianTreeEquals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String s1 = sc.nextLine().trim();
            if (s1.equals("0")){
                break;
            }
            String s2 = sc.nextLine().trim();
            TreeNode root1 = buildTree(s1.toCharArray());
            TreeNode root2 = buildTree(s2.toCharArray());
            if (isSameTree(root1,root2)){
                System.out.println("YES");
            }else {
                System.out.println("No");
            }
        }
    }
    //写两个方法组合起来完成先序二叉树的创建
    public static TreeNode buildTree(char[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        return buildTree(arr,new int[]{0});//长度为1，初值为0的数组idx
    }
    /**
     *
     * @param arr 当前输入的字符串
     * @param idx 一个长度为1的数组代表着输入的字符串的下标
     * @return 树的根节点
     */
    private static TreeNode buildTree(char[] arr,int[] idx){
        if (idx[0] >= arr.length || arr[idx[0]] =='0'){
            idx[0] ++;//下标位置向后
            return null;//下标比字符串都要长或者字符串为0即为空结点
        }
        TreeNode root = new TreeNode(arr[idx[0]] ++);
        root.left = buildTree(arr,idx);
        root.right =buildTree(arr,idx);
        return root;
    }
    //判断是否相同
    public static boolean isSameTree(TreeNode p,TreeNode q){
        if (p == null && q ==null){
            return true;
        }
        if (p == null || q== null){
            return false;
        }
        if (p.value != q.value){
            return false;
        }
        //递归地去同时比较两个树对应的左右结点
        return isSameTree(p.left,q.left) && isSameTree(p.right,p.right);
    }
}
//树结点类
class TreeNode{
    char value;
    TreeNode left;
    TreeNode right;

    public TreeNode(char value) {
        this.value = value;
    }
}


```

## 264 基于二叉链表的二叉树左右子树的交换

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写递归算法交换该二叉树的左右孩子。

多组数据。每组数据一行，为二叉树的先序序列（序列中元素为‘0’时，表示该结点为空）。当输入只有一个“0”时，输入结束。

### 第一想法

过程肯定是包括建立树、交换树。跟上一道题差不多，但是上一道题的建立树的方法过于复杂了，这道题简化一下。

### 正解

**这道题对于递归使用到了极致，不论是建树还是交换，甚至是输出。**

- 建树：传入字符数组与记录下标位置的数组（长度为1，值从0开始递增），如果下标超过长度或者对应位置为0（题目要求）返回空的同时下标也要往后走，即idx数组值 ++
- 交换树：也要先进行健壮性判断，是否为空。判断完后跟交换两个值一样的操作。最后进行递归。
- 输出树：也使用递归，挺简洁的。

### 代码实现

```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写递归算法交换该二叉树的左右孩子。
 */
public class LianTreeChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("0")){
                break;
            }
            char[] arr = input.toCharArray();
            int[] idx = new int[]{0};
            //建树，返回树根
            TreeNode2 root = buildTree(arr,idx);
            swapTree(root);//交换
            printPreOrder(root);
            System.out.println();
        }
    }
    
    //递归先序建立树
      public static TreeNode2 buildTree(char[] arr,int[] idx){
           if (idx[0] == arr.length || arr[idx[0]] =='0'){
               idx[0] ++;
               return null;//代表可能是空结点或者走到了最后
           }
          TreeNode2 root = new TreeNode2(arr[idx[0]]);
          idx[0] ++;
          root.left = buildTree(arr,idx);
          root.right = buildTree(arr,idx);
          return root;
      }

    //递归交换左右
    public static void swapTree(TreeNode2 root){
        if (root == null){
            return;
        }
        TreeNode2 tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        swapTree(root.left);
        swapTree(root.right);
    }
    //递归先序输出序列
    public static void printPreOrder(TreeNode2 root){
        if (root == null){
            return;
        }
        System.out.print(root.value);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
class TreeNode2{
    TreeNode2 left;
    TreeNode2 right;
    char value;

    public TreeNode2(char value) {
        this.value = value;
    }
}

```

## 265 基于二叉树的双序遍历

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写递归算法实现该二叉树的双序遍历（双序遍历是指对于二叉树的每一个结点来说，先访问这个结点，**再按双序遍历它的左子树，然后再一次访问这个结点，接下来按双序遍历它的右子树**）。

```html
ab000 —— abba
```

### 第一想法

这个双序遍历相比于先序遍历多了一步，就是要再访问一次自己。这个再访问一次自己的操作要怎么整？在先序建立里面加还是在输出方法里面加入呢？

### 正解

这句访问自己得加在输出方法中，具体加在左右递归之间。

### 代码实现：
```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，
 * 编写递归算法实现该二叉树的双序遍历（双序遍历是指对于二叉树的每一个结点来说，
 * 先访问这个结点，再按双序遍历它的左子树，然后再一次访问这个结点，接下来按双序遍历它的右子树）。
 */
public class LianTreeDoubleGo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("0")){
                break;
            }
            int[] idx = new int[]{0};
            TreeNodeD result = buildTree(input.toCharArray(), idx);
            printTree(result);
            System.out.println();
        }
    }
    //先先序地建立二叉树
    public static TreeNodeD buildTree(char[] ch,int[] idx){
        if (idx[0] == ch.length || ch[idx[0]] =='0'){
            idx[0] ++;
            return null;
        }
        //
        TreeNodeD root = new TreeNodeD(ch[idx[0]]);
        idx[0] ++;
        root.left = buildTree(ch,idx);
        root.right = buildTree(ch,idx);
        return root;
    }
    //双序体现在输出的时候
    public static void printTree(TreeNodeD root){
        if (root == null){
            return;
        }
        System.out.print(root.value);
        printTree(root.left);
        System.out.print(root.value);
        printTree(root.right);
    }
}
class TreeNodeD{
    TreeNodeD left;
    TreeNodeD right;
    char value;

    public TreeNodeD(char value) {
        this.value = value;
    }
}

```

## 269 基于二叉链表的三种遍历

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写三个递归算法分别实现二叉树的先序、中序和后序遍历。

### 第一想法

更改先序遍历中语句的顺序即可，可以仿照代码随想录当中。

### 正解

先序是这样的，中序左根右，后序左右根。

```java
public static TreeNode2 buildTree(char[] arr,int[] idx){
           if (idx[0] == arr.length || arr[idx[0]] =='0'){
               idx[0] ++;
               return null;//代表可能是空结点或者走到了最后
           }
          TreeNode2 root = new TreeNode2(arr[idx[0]]);
          idx[0] ++;
          root.left = buildTree(arr,idx);
          root.right = buildTree(arr,idx);
          return root;
      }
```

### 代码实现：

改一下三句话的顺序就行了。

## 271 基于二叉链表二叉树的高度计算

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，，编写递归算法计算二叉树的高度。

### 第一想法：

这个递归计算高度肯定是在输出语句的时候，当遍历到哪里为空的时候高度进行++还是怎么办呢？

### 正解：

该算法使用递归计算二叉树的高度。对于每个节点，它的高度等于它的左右子树高度的较大值加上1。空节点的高度为0。

这个递归算法的实现过程如下：

1. 如果当前结点为空（即遇到了 0），返回高度 0。
2. 如果当前结点不为空，则分别递归计算它的左子树和右子树的高度，并取它们的较大值，再加上 1，就是当前结点所在的子树的高度。

### 代码实现：

```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class LianTreeHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("0")){
                break;
            }
            int[] idx = new int[]{0};
            TreeNodeH tree = buildTree(input.toCharArray(), idx);
            System.out.println(GetHeight(tree));
        }
    }
    //建树
    public static TreeNodeH buildTree(char[] ch,int[] idx){
        if (idx[0] == ch.length || ch[idx[0]] =='0'){
            idx[0] ++;
            return null;
        }
        TreeNodeH root = new TreeNodeH(ch[idx[0]]);
        idx[0] ++;
        root.left = buildTree(ch,idx);
        root.right = buildTree(ch,idx);
        return root;
    }
    //计算高度，从根的角度来看计算出左右子树高度最大值再+1即可。
    public static int GetHeight(TreeNodeH root){
        if (root == null){
            return 0;
        }
        int H1 = GetHeight(root.left);
        int H2 = GetHeight(root.right);
        return Math.max(H1,H2) + 1;
    }
}
class TreeNodeH{
    TreeNodeH left;
    TreeNodeH right;
    char value;

    public TreeNodeH(char value) {
        this.value = value;
    }
}

```

## 270 基于二叉链表二叉树结点数目统计

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写三个递归算法对二叉树的结点（度为0、1、2）个数进行统计。

### 第一想法

求度为0的结点，即叶子结点的个数，递归到左右子树都为空时返回数目+1；度为1的递归到左右空一个，有一个就行，度为2的进行到只要有一个为空就返回。

**我觉得应该从递归的结束条件出发**。度为1结束条件是没孩子和全孩子，0的结束条件是只要有孩子就退出。

### 正解：

- 其实要不了那么难，对于这三个度的个数我们申请一个长度为3的数组来保存即可，满足上述的条件对应数组下标值++。

### 代码实现：

我也不知道哪里错了。能通过案例但是无法通过oj。

```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class LianTree270Nums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("0")){
                break;
            }
            int[] idx = new int[]{0};
            TreeNode270 root = buildTree(input.toCharArray(), idx);
            int[] nums = new int[3];
            count(root,nums);
            System.out.println(nums[0] + " " + nums[1] + " " + nums[2]);
        }
    }
    //
    public static TreeNode270 buildTree(char[] ch,int[] idx){
        if (idx[0] == ch.length || ch[idx[0]] =='0'){
            idx[0] ++;
            return null;
        }
        
        TreeNode270 root = new TreeNode270(ch[idx[0]]);
        idx[0]++;
        root.left = buildTree(ch,idx);
        root.right = buildTree(ch,idx);
        return root;
    }
    //判断各个度的数目
    public static void count(TreeNode270 root,int[] nums){
        if (root == null){
            return;
        }else if (root.left == null && root.right == null){
            nums[0] ++;//度为0的条件
        }else if (root.left == null || root.right == null){
            nums[1] ++;//度为1的条件
        }else {
            nums[2] ++;
        }
        count(root.left,nums);
        count(root.right,nums);
    }
}
class TreeNode270{
    TreeNode270 left;
    TreeNode270 right;
    char value;

    public TreeNode270(char value) {
        this.value = value;
    }
}
```

## 266 基于二叉链表的二叉树最大宽度计算

### 题目要求：

设二叉树中每个结点的元素均为一个字符，按先序遍历的顺序建立二叉链表，编写算法计算该二叉树的最大宽度(二叉树的最大宽度是指二叉树所有层中结点个数的最大值)。

### 第一想法

没啥想法，这个计算最大宽度总不能用递归了吧。但是二叉树的题目好像都得用递归解决。

### 正解：

使用递归方法，多个递归。

- 先得到二叉树的深度
- 再去得到每一层的宽度，**这个获得宽度的方法很重要。传入参数level**
- 最后实现得到最大宽度的函数，每次都去取每一层宽度的最大值

### 代码实现：
```java
package com.luluedu.beilin.Tree;

import jdk.nashorn.api.tree.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class LianTreeMaxWidth266 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("0")){
                break;
            }
            int[] idx = new int[]{0};
            TreeNode266 root = buildTree(input.toCharArray(), idx);
            int maxWidth = getMaxWidth(root);
            System.out.println(maxWidth);
        }
    }
    //建立二叉树
    public static TreeNode266 buildTree(char[] ch,int[]idx){
        if (idx[0] == ch.length || ch[idx[0]] =='0'){
            idx[0] ++;
            return null;
        }
        TreeNode266 root = new TreeNode266(ch[idx[0]]);
        idx[0] ++;
        root.left = buildTree(ch,idx);
        root.right = buildTree(ch,idx);
        return root;
    }
    //获取二叉树的深度
    public static int getDepth(TreeNode266 root){
        if (root == null){
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth,rightDepth) + 1;
    }
    //递归地遍历每一层获得二叉树的宽度
    public static int getWidth(TreeNode266 root,int level){
        if (root ==null){
            return 0;
        }
        if (level == 1){
            return 1;//只有一层时返回宽度为1
        }
        int leftWidth = getWidth(root.left,level -1);
        int rightWidth = getWidth(root.right,level - 1);
        return leftWidth + rightWidth;//最终返回左右子树的宽度之和，即为下一层的宽度
    }
    //得到最大宽度
    public static int getMaxWidth(TreeNode266 root){
        if (root == null){
            return 0;
        }
        int depth = getDepth(root);
        int maxWidth = 0;
        for (int i = 0; i <= depth ; i++) {
            int width = getWidth(root,i);
            maxWidth = Math.max(maxWidth,width);
        }
        return maxWidth;
    }
}
class TreeNode266{
    TreeNode266 left;
    TreeNode266 right;
    char value;

    public TreeNode266(char value) {
        this.value = value;
    }
}

```

## 288 二叉排序树的判定

### 题目要求

- 假设二叉树每个结点的元素均为一个单字符，根据给定的字符序列按照先序遍历的顺序递归创建该树的二叉链表，然后判断该二叉树是否为二叉排序树。

- 多组数据，每组数据有一行。每行为一个二叉树对应的前序序列（其中‘#’表示空树）。当序列为“#”时，输入结束。

### 第一想法：

- 首先，这道题建立二叉链表的时候把往常的0替换为了#。
- 其次，根据题目给出的样例，这棵二叉排序树是一个左小右大的树。判断时大概率也要使用递归的方法，如果左小右大返回true，然后再去对左右递归判断。

### 正解：

- 在判断是否为二叉排序树时，使用到了递归。并且传入了两个值——char类型的最大值与最小值。
- **用来作为每次判断的允许范围，左子树范围在【min，root.value - 1】**只要不超出这个范围左子树都是满足条件的。右子树同理。

### 代码实现：

```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class BinarySortTree288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.next();
            if (input.equals("#")){
                break;
            }
            int[] idx = new int[]{0};
            TreeNodeB root = BuildTree(input.toCharArray(), idx);
            boolean result = sortTree(root, Character.MIN_VALUE, Character.MAX_VALUE);
            if (result){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
    //建树
    public static TreeNodeB BuildTree(char[] ch,int[] idx){
        if (idx[0] == ch.length || ch[idx[0]] =='#'){
            idx[0] ++;
            return null;
        }
        TreeNodeB root = new TreeNodeB(ch[idx[0]]);
        idx[0] ++;
        root.left = BuildTree(ch,idx);
        root.right = BuildTree(ch,idx);
        return root;
    }

    /**
     * 判断是否为二叉排序树
     * @param root
     * @param min 字符类型的最小值
     * @param max 字符类型的最大值
     * @return
     */
    public static boolean sortTree(TreeNodeB root,char min,char max){
        if (root == null){
            return true;//注意这里。
        }
        //一般先列出错误条件，正确条件就剩下即可
        if (root.value < min || root.value > max){
            return false;
        }
        //分别对左右子树进行判断
        return sortTree(root.left,min,(char)(root.value - 1)) && sortTree(root.right,(char)(root.value +1),max);
    }
}
class TreeNodeB{
    TreeNodeB left;
    TreeNodeB right;
    char value;

    public TreeNodeB(char value) {
        this.value = value;
    }
}

```

## 289二叉树限定条件下的输出

### 题目要求：

已知二叉排序树采用二叉链表存储结构，根结点的指针为T,链结点的结构为(lchild,data,rchild),其中lchild、rchild分别指向该结点左，右孩子的指针，data域存放结点数据。试编写算法，从小到大输出二叉排序树中所有数值大于等于x的结点的数据。要求先找到第一个满足条件的结点后，再依次输出其他满足条件的结点。

### 第一想法：

- 在一个没有任何规律的二叉树中要去找到大于x的结点，并且先找到第一个大于等于的数据，所谓的第一个是由查找顺序来定的吗？（看题目案例好像是数字意义上第一个大于的），那就还要对这个大于的数组进行排序吗？放入的时候进行排序有点像冒泡。

- 搞一个层序遍历，把大于的数据全部放到一个数组中去最后输出？走的时候靠从根节点开始的那个指针。

### 正解：

- AI给出的答案与我开始想的差不多，可以先建立一棵二叉排序树，然后再对其进行操作。
- 建议成二叉排序树之后，就可以让他去左边递归找到大于等于，递归进去可以保证输出第一个满足的。

### 代码实现：

- 这个题的代码有难度，建立二叉排序树和输出对应的值的递归都很难理解。
- 仍然是一个通过案例但是无法ac的代码。具体我要debug一下。

```java
package com.luluedu.beilin.Tree;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class BinarySearchTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            TreeNodeBi root = null;
            //for循环每次找到插入位置来构建一棵二叉排序树
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                root = insert(root,val);
            }
            int x = sc.nextInt();
            printGreaterThanOrEqual(root,x);
            System.out.println();
        }
    }
    //写一个方法构造二叉排序树,这个是寻找二叉排序树的插入位置
    public static TreeNodeBi insert(TreeNodeBi root,int val){
        if (root == null){
           return new TreeNodeBi(val);
        }
        if (val < root.data){
            root.lchild = insert(root.lchild,val);
        }else if (val > root.data){
            root.rchild = insert(root.rchild,val);
        }
        return root;//最后递归完返回的一定是最原始的那个根结点。
    }
    //写一个找值的方法
    public static void printGreaterThanOrEqual(TreeNodeBi node,int x){
        if (node == null){
            return;
        }
        if (node.data < x){
            printGreaterThanOrEqual(node.rchild,x);
        }else {
            //递归的进行如果值小了去左边
            printGreaterThanOrEqual(node.lchild,x);
            System.out.print(node.data + " ");//这句输出卡在这里很难理解
            printGreaterThanOrEqual(node.rchild,x);
        }
    }
}
class TreeNodeBi{
    int data;
    TreeNodeBi lchild;
    TreeNodeBi rchild;

    public TreeNodeBi(int data) {
        this.data = data;
        this.lchild = null;
        this.rchild = null;
    }
}
```