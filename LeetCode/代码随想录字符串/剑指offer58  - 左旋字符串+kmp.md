# 剑指offer58  - 左旋字符串

## 题目要求

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

## 第一想法

- 如果把字符串转换为字符数组，那由于数组的长度受限，我需要移动整个数组的元素，所以这个方法不考虑。

- 如果使用Builder新建一个字符串，动态长度可变，然后先把后面的字符放到新的前面，再把要旋转的放到新的后面。

- 可以在原字符串上面操作吗？使用指针？分成两个部分——一个指向开始，一个指向不用左旋的。好像不太对。

## 困难

使用Builder新建字符串的思路是没有错的，但是空间复杂度还是太高了。所以在源字符串上操作是可行的，只是我没有想到这个方法罢了。

## 正解

类比上一道字符串题目，这些翻转题目往往都存在一定的规律，比如这道题目可以先把ab翻转，再把后面翻转，再对整个字符串进行翻转。实现了在原字符串上操作。

## 代码实现1
```java
class Solution_02{
    //在原数组的基础上进行操作
    public String reverseWords(String s,int n){
        char[] chars = s.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,s.length()-1);
        reverse(chars,0,s.length()-1);
        return new String(chars);
    }
    //写一个颠倒字符数组里指定位置元素的方法，这里注意啊，异或操作可以实现两个位置元素的互换
    public void reverse(char[] chars,int left,int right){
        while (left < right){
            chars[left] ^= chars[right];//左右异或结果放在左边里面
            chars[right] ^= chars[left];//右边和上面结果进行异或只剩下了原来左边的值，并且最终放入右边的区域
            chars[left] ^= chars[right];//异或得到原来右边的值，放入左边位置。
            //这样就完成了左右位置的交换
            left ++;
            right --;
        }
    }
}

```
## 代码实现2
```java
class SolutionLeft{
    public String reverse(String s,int n){
        StringBuilder sb = new StringBuilder();
        //完成后半部分的字符填充
        for (int i = n ; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        //将需要左旋的填充到后面。
        for (int i = 0; i < n ; i++) {
            sb.append(s.charAt(i));
        }
        //将builder转换为sb
        String s1 = sb.toString();
        return s1;
    }
}
```

# 28找出字符串第一个匹配的下标项

## 题目要求：

## 第一想法

## 困难

## 正解

## 代码实现

# KMP算法

## 前缀

包含首字母，不包含尾字母的**所有子串**。

## 后缀

包含尾字母，不包含首字母的所有子串。

## 最长相等前后缀

对所有的子串记录其最长相等前后缀，保存于next数组中；当发生失配时，**前一个字符的前缀表的数值**是多少就到这里去重新匹配。

## 思路

j指向前缀末尾位置，i指向后缀末尾位置。j其实也代表了i之前包括i子串最长相等前后缀的长度