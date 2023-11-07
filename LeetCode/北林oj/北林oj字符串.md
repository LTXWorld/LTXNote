# 北林oj字符串

## 256 病毒感染检测

### 题目要求：

医学研究者最近发现了某些新病毒，通过对这些病毒的分析，得知它们的DNA序列都是环状的。现在研究者收集了大量的病毒DNA和人的DNA数据，想快速检测出这些人是否感染了相应的病毒。为方便研究，研究者将人的DNA和病毒的DNA均表示成由一些小写字母组成的字符串，然后检测某种病毒的DNA序列是否在患者的DNA序列中出现过，如果出现过，则此人感染了病毒，否则没有感染。注意：人的DNA序列是线性的，而病毒的DNA序列是环状的。

多组数据，每组数据有一行，为序列A和B，A对应病毒的DNA序列，B对应人的DNA序列。A和B都为“0”时输入结束。

对于每组数据输出一行，若患者感染了病毒输出“YES”，否则输出“NO”。

```html
abbab abbabaab  yes
baa cacdvcabacsd yes
abc def   no
0 0
```

### 第一想法：

对于病毒字符串，它是环形的。意思是只要其中的一部分字符出现在人的字符串中就可以。

那对人字符串里面出现的字符进行统计？然后再去判断病毒字符串里面的字符是否有配得上的？ 

### 正解：

这道题是典型的KMP匹配算法，里面加了一个环状的条件。

这道题目目前对我来说还是比较难的。

- 先找到前缀表的最长相等前后缀，再把不匹配位置跳到前缀后一个位置重新开始匹配
- 前缀：包含首字母，不包含尾字母的所有子串；后缀：包含尾字母，不包含首字母
- 计算模式串的每个子串的最长相等前后缀——即前缀表
- 巧合的是，**失配位置前一位前缀表记录的长度恰好是继续匹配位置的下标。**

### 代码实现：

## 257 统计字符出现的频度

### 题目要求

写一个算法统计在输入字符串中各个不同字符出现的频度并将结果输出(字符串中的合法字符为A-Z之间的26个字母和0-9之间的10个数字)

多组数据，每组数据有一行，为待统计字符频度的字符串。当字符串为“0”时，输入结束

对于每组数据输出n行，每一行为一个字符出现的频度（只输出存在的字符，格式为：字符：频度），字符排列顺序按照ASCII码从小到大的顺序。

### 第一想法

设置一个新数组来保存其中的频度，一开始我想把新数组的大小设置为36（26+10），但是ASCII码对不上，它不是连续的。不能直接拿某个遍历到的字符去-A或者0什么的。

一开始我还想把字符串通过toCharArray转换为一个字符数组，后来发现charAt也可以。

### 正解：

- 第一想法其实是对的，这个36大小的数组和减法操作是可以的。**0-9下标用来存0-9，只需要字符-'0'即可；然后10-36下标用来存大写字母，只需要用字符-'A' +10即可。**

- **注意输出时，得到具体的字符和数字的方法也很关键。**

- 其实使用java中的一个函数也能更快地解决——`isLetterOrDigit` 是Java中的一个方法，**用于判断一个字符是否为字母或数字**。它属于Character类中的静态方法，接受一个char参数，返回一个boolean值。（按照这种方法就需要搞一个非常大的数组）
- 并且字符可以直接当作数字来用，编译器会直接使用他们的ASCII码。

### 代码实现
```java
package com.luluedu.beilin.String_;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class Pin_ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //
        while (true){
            String str = sc.nextLine();
            if (str.equals("0")){
                break;
            }
            //进行频度统计，利用其ASCII码值，A-Z 0-9，先把字符串转换为字符数组，然后再新建一个数组来存放频度
            int[] pin = getPin(str);
            PrintInfo(pin);
        }
    }
    public static int[] getPin(String str){
        int[] pin = new int[36];
        //下标用其字符直接减去A？数字是48-57，字母是65-90
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >='0' && c <='9'){
                pin[c-'0'] ++;
            }else if (c >='A' && c <='Z'){
                pin[c-'A' + 10] ++;
            }
        }
        return pin;
    }
    //输出函数
    public static void PrintInfo(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                char c =(char) (i<10 ? i +'0' : i -10 +'A');//其实就是跟上面那个算法反着加过来变成字符
                System.out.println(c + ":" + arr[i]);
            }
        }
    }
}

```

## 258 递归实现字符串的逆序存储

### 题目要求：

写一个递归算法来实现字符串的逆序存储，要求空间复杂度为O(1)。

### 第一想法：

使用栈完成，结果怎么空间复杂度为1啊。

还要用递归，怎么写啊？

### 正解：

思路就是取出第一个先放着，然后对后面的所有字符串进行相同操作，取剩最后一个时，再反过来一起加起来。

递归的结束条件是：字符串为空；单次递归操作：如上；

### 代码实现：
```java
package com.luluedu.beilin.String_;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class LoopReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String line = sc.nextLine();
            if (line.equals("0")){
                break;
            }
            String reversed = reverseString(line);
            System.out.println(reversed);
        }
    }
    public static String reverseString(String str){
        if (str.isEmpty()){
            return str;
        }else {
            char first = str.charAt(0);//先取出第一个字符，然后对后面的进行逆转。
            String restOfString = str.substring(1);//获取字符串从下标1开始到最后的字符串
            String reversedRestOfString = reverseString(restOfString);
            return reversedRestOfString + first;//最后一直剥离，拨到最后剩一个开始递归加起来完成逆转，顺序不能反了。
        }
    }
}

```

## 259 字符串的插入操作

### 题目要求

编写算法，实现下面函数的功能。函数void insert(char*s,char*t,int pos)将字符串t插入到字符串s中，插入位置为pos（插在第pos个字符前）。假设分配给字符串s的空间足够让字符串t插入。(说明：不得使用任何库函数)

多组数据，每组数据有三行，第一行为插入的位置pos，第二行为要被插入的字符串s，第三行为待插入的字符串t。当pos为“0”时输入结束

### 第一想法

字符串String在Java中是使用字符数组保存的，如果要插入的话得让后面的字符后移长度位。

并且插入位置的前一个得进行定位，从这里的后面开始插入。

### 正解

思想是对的，但是写到这里出错了：str1.charAt(i+len2) = str1.charAt(i);——字符串不允许直接后移，需要转变为字符数组再进行后移。

但是正确答案老显示数组越界异常？找不出错误来。

### 代码实现

```java
package com.luluedu.beilin.String_;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class InsertS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = sc.nextInt();
            sc.nextLine();
            if (n == 0){
                break;
            }
            char[] c1 = sc.nextLine().toCharArray();
            char[] c2 = sc.nextLine().toCharArray();
            insert(c1,c2,n);
            for (int i = 0; i < c1.length; i++) {
                System.out.print(c1[i]);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param c1 源字符串
     * @param c2 待插入的字符串
     * @param pos 待插入的位置
     * @return 返回插入完成后的字符串
     */
    public static void insert(char[] c1,char[] c2,int pos){
        if (pos < 1){
            return;
        }
        int len1 = c1.length;
        int len2 = c2.length;
        //不让用库函数什么意思
        //部分后移
        for (int i = len1 - 1; i >= pos - 1 ; i--) {
            c1[i + len2] = c1[i];
        }
        //插入
        for (int i = 0; i < len2; i++) {
            c1[pos + i - 1] = c2[i];
        }
    }
}

```

## 