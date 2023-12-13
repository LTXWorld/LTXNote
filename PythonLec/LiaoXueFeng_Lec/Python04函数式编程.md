# Python04函数式编程

函数式编程的一个特点就是，允许把函数本身作为参数传入另一个函数，还允许返回一个函数！

个人理解是将函数本身作为一个变量进行运算处理，函数嵌套执行。

## 高阶函数

### 变量指向函数

### 函数名是什么

- 函数名其实就是指向函数的变量

### 传入函数

- 那么一个函数就可以接收另一个函数作为参数，这种函数就称之为高阶函数。

```python
def add(x, y, f):
    return f(x) + f(y)

print(add(-5,-4,abs))
```



## Map

`map()`函数接收两个参数，一个是函数，一个是`Iterable`，`map`将传入的函数依次作用到迭代序列的每个元素，并把结果作为新的`Iterator`返回。

```python
def f(x):
    return x * x
r = map(f,[1,2,3,4,5,6,7,8,9])
print(list(r))

L1 = list(map(str,[1,2,3,4,5,6]))#最后map得到的结果是一个Iterator迭代器（惰性），需要将其转换为list列表输出
```

## Reduce

`reduce`把一个函数作用在一个序列`[x1, x2, x3, ...]`上，这个函数必须接收两个参数，`reduce`把结果继续和序列的下一个元素做累积计算

` reduce(f, [x1, x2, x3, x4]) = f(f(f(x1, x2), x3), x4`

```python
DIGITS = {'0' : 0, '1' : 1, '2': 2, '3': 3, '4': 4, '5' : 5,'6' : 6,'7': 7,'8':8,'9': 9}
def str2int(s):#作用是将字符串转换为int类型的值
    def fn(x,y):
        return x * 10 + y#将y拼接到x后面
    
    def char2num(s):#将字符串分割成字符，返回一个迭代器
        return DIGITS[s]
    return reduce(fn,map(char2num,s))
```

