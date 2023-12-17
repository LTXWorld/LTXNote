# Python06异常处理

## Try...except...finally

Try包裹可能出错的代码，except来捕获可能出现的错误，finally一定执行

- except可以捕获多种错误，不但捕获该类型的错误，还把其子类也“一网打尽”
- 不需要在每个可能出错的地方去捕获错误，只要在合适的层次去捕获错误就可以了

```python
try:
    print('try...')
    r = 10 / 2
    print('result:' , r)
except ZeroDivisionError as e:
    print('except:' , e)
except ValueError as e:
    print('ValueError:', e)
else:
    print('no erro!')
finally:
    print('finally...')
```

-  出错的时候，一定要分析错误的调用栈信息，才能定位错误的位置

## 记录错误：

导入内置的`logging`模块即可

```python
import logging
def foo(s):
    return 10 / int(s)

def bar(s):
    return foo(s) * 2

def main():
    bar('0')

print(main())
```

## 抛出错误：

错误是class，捕获一个错误就是捕获到该class的一个实例。因此，错误并不是凭空产生的，而是有意创建并抛出的。Python的内置函数会抛出很多类型的错误，我们自己编写的函数也可以抛出错误

```python
class FooError(ValueError):
    pass

def foo(s):
    n = int(s)
    if n==0:
        raise FooError('invalid value: %s' %s)
    return 10 / n
```

## 调试

### 断言assert：

`assert`的意思是，表达式`n != 0`应该是`True`，否则，根据程序运行的逻辑，后面的代码肯定会出错;如果断言失败，`assert`语句本身就会抛出`AssertionError`

断言的开关“-O”是英文大写字母O,关闭后你可以将它们全部当作pass看待

```python
def foo(s):
    n = int(s)
    assert n !=0,'n is zero'
    return 10 / n

def main():
    foo('0')
```

### logging（终极武器）

和`assert`比，`logging`不会抛出错误，而且一条语句可以同时输出到不同的地方，比如console和文件。

允许你指定记录信息的级别，有`debug`，`info`，`warning`，`error`等几个级别，当我们指定`level=INFO`时，`logging.debug`就不起作用了

```python
import logging 
logging.basicConfig(level=logging.INFO)
s = '0'
n = int(s)
logging.info('n = %d' % n)
```

### 启动pdb.set_trace

可以开启一个类似于命令行的窗口进行指令操作。

```python
import pdb
s = '0'
n = int(s)
pdb.set_trace()
print(10 / n)
```



