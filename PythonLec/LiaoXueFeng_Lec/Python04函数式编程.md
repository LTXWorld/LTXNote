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



### Map

`map()`函数接收两个参数，一个是函数，一个是`Iterable`，`map`将传入的函数依次作用到迭代序列的每个元素，并把结果作为新的`Iterator`返回。

```python
def f(x):
    return x * x
r = map(f,[1,2,3,4,5,6,7,8,9])
print(list(r))

L1 = list(map(str,[1,2,3,4,5,6]))#最后map得到的结果是一个Iterator迭代器（惰性），需要将其转换为list列表输出
```

### Reduce

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

### Filter

和`map()`不同的是，`filter()`把传入的函数依次作用于每个元素，然后根据返回值是`True`还是`False`决定保留还是丢弃该元素

注意到`filter()`函数返回的是一个`Iterator`，也就是一个惰性序列，所以要强迫`filter()`完成计算结果，需要用`list()`函数

### sorted

用`sorted()`排序的关键在于实现一个映射函数。

```python
sorted(['bob','about','Zoo','Credit'],key=str.lower,reverse=True)#不区分字符串大小写且进行反向排序
```

## 闭包：(返回函数)

**牢记该函数并未执行，返回函数中不要引用任何可能会变化的变量**。

在 Python 中，闭包**记住了函数的变量，而不是变量的值**；发生的原因是：**内层函数引用了外层函数的局部变量**

所以返回函数不要引用任何*循环变量，或者后续会发生变化的变量*。

```python
def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i * i
        fs.append(f)
    return fs
f1,f2,f3 = count()
```

- 每个 `f` 函数都是一个闭包，它们“记住”了变量 `i` 的引用，而不是在定义时 `i` 的值。
- 当 `count` 函数结束时，`i` 的值已经变成了 `3`（因为 `for` 循环结束时，`i` 等于 `3`)

使用闭包时，对外层变量赋值前，需要先使用`nonlocal`声明该变量不是当前函数的局部变量。

```python
def inc():
    x = 0
    def fn():
        nonlocal x#可以对外层局部变量赋值
        x = x + 1
        return x
    return fn
```

## Lambda匿名函数

匿名函数有个限制，就是只能有一个表达式，不用写`return`，返回值就是该表达式的结果

## 装饰器：

函数对象有一个`__name__`属性（注意：是前后各两个下划线），可以拿到函数的名字

```python
def log(func):
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)#在这里返回实际的函数功能
    return wrapper

@log
def now():
    print('2015-3-25')
```

- 在 `log` 内部定义了另一个函数 `wrapper`，这个函数用于包装 `func`。
- `wrapper` 接受任意数量的位置参数 (`*args`) 和任意数量的关键字参数 (`**kw`)。这允许它可以接受和 `func` 相同的任何参数
- 这意味着 `log` 不是直接执行 `func`，而是返回一个新的函数，这个新函数会调用 `func` 并在调用前后执行一些附加操作

注意上面那段代码，在不使用 `functools.wraps` 的情况下，装饰器返回的新函数 `wrapper` 会“失去”被装饰函数的一些元信息，如函数名称、文档字符串、注解等

```python
import functools
def log(func):
    @functools.wraps(func)#加上这一句可以让wrapper保留原来函数的元信息
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)#在这里返回实际的函数功能
    return wrapper
```

## 偏函数：

简单总结`functools.partial`的作用就是，把一个函数的某些参数给固定住（也就是设置默认值），返回一个新的函数，调用这个新函数会更简单

创建偏函数时，实际上可以接收函数对象、`*args`和`**kw`这3个参数

```python
import functools
int2 = functools.partial(int,base=2)
print(int2('10000000'))
```



## 补充，args和kwrags

1. **`args`**:
   - `*args` 用于收集所有**未命名的位置参数。这些参数被打包进一个元组**中。
   - 在函数体内，您可以通过 `args` 来访问这些参数。
   - 例如，在函数定义 `def func(*args):` 中，您可以传递任意数量的位置参数给 `func`，如 `func(1, 2, 3)`，这里 `args` 将是元组 `(1, 2, 3)`。
2. **`kwargs`**:
   - `**kwargs` 用于收集**所有未命名的关键字参数。这些参数被打包成一个字典**。
   - 在函数体内，您可以通过 `kwargs` 访问这些参数的键和值。
   - 例如，在函数定义 `def func(**kwargs):` 中，您可以传递任意数量的关键字参数给 `func`，如 `func(a=1, b=2)`，这里 `kwargs` 将是字典 `{'a': 1, 'b': 2}`。
