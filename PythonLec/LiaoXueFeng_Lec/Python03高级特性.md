# Python03高级特性

## 切片

从一个具体问题入手，使用切片实现`trim()`函数，去掉字符串的前后空格

### 方法一：暴力法

- 找到首尾空格的起始点，将中间的字符串切片出来

```python
def my_trim(s):
    start = 0
    while start < len(s) and s[start] ==' ':
        start += 1
    end = len(s) - 1
    while end > 0 and s[end] == ' ':
        end  -= 1
    #因为左闭右开的缘故，end已经来到了非空格的位置，所以需要+1
    return s[start:end + 1] if start < end else ''
```

### 方法二：递归法

- 从前后的空格一个一个地递归删除。

```python
def my_trim2(s):
    if s[0:1] ==' ':
        s = s[1:]
        return my_trim2(s)
    elif s[-1:] == ' ':
        s = s[:-1]
        return my_trim2(s)
    else:
        return s
```

### 举例二：（详解切片）

`num[::-1]` 是一种切片操作，用于反转一个序列

- 切片操作符有三个参数，格式为 `[开始:结束:步长]`。如果省略 `开始` 和 `结束`，则默认选取整个序列。
- `步长` 定义了选取元素的间隔。正值表示从左到右选取元素，负值表示从右到左选取元素。

## 高级的迭代

### for循环

- for循环可以同时引用两个变量

- 当我们使用`for`循环时，只要作用于一个可迭代对象，`for`循环就可以正常运行，而我们不太关心该对象究竟是`list`还是其他数据类型
- 通过`collections.abc`模块的`Iterable`类型判断是否为可迭代对象

```python
from collections.abc import Iterable
isinstance('abc',Iterable)
print(isinstance(132,Iterable))
```

## 列表生成式：

Python内置的非常简单却强大的可以用来创建list的生成式。

- 可以将**表达式（必须能算出结果）**和for循环甚至if条件判断全部结合在一起，生成一个列表
- 注意这里跟在for循环后面的**if是一个筛选条件，不能加else**

```python
L = [x*x for x in range(1,11) if x % 2 == 0]# 语句+for循环+条件判断
L2 = [m + n for m in 'ABC' for n in 'XYZ']# 甚至可以使用两个for循环
L4 = [k + '=' + v for k,v in d.items()]#从而对字典进行操作

L6 = ['Hello', 'World', 18, 'Apple', None]
L7 = [s.lower() for s in L6 if isinstance(s, str)]
```

## 生成器：

一边循环一边计算的机制，称为生成器：generator，其**保存的是算法**，generator也是可迭代对象

- 只要把一个列表生成式的`[]`改成`()`，就创建了一个generator：

- 如果一个**函数定义中包含`yield`关键字**，那么这个函数就不再是一个普通函数，而是一个generator函数，调用一个generator函数将返回一个**generator对象**
- generator的函数，在每次调用`next()`的时候执行，遇到`yield`语句返回，再次执行时从上次返回的`yield`语句处继续执行
- 调用generator函数会**创建一个generator对象**，多次调用generator函数会创建多个相互独立的generator；所以最好创建一个generator对象就行，对着一个对象使用next方法

## 迭代器：

可以被`next()`函数调用并不断返回下一个值的对象称为迭代器：`Iterator`，实际上是**一个需要next的数据流**；这个概念与可迭代对象要区分开。

- 生成器都是`Iterator`对象，但`list`、`dict`、`str`虽然是`Iterable`，却不是`Iterator`
- 把`list`、`dict`、`str`等`Iterable`变成`Iterator`可以使用**`iter()`函数**：