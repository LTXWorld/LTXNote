# Python遇到问题02

## 函数返回多个值：

```python
def move(x,y,step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx,ny

x,y = move(100,100,60,math.pi / 6)
print(x,y)

r = move(100,100,60,math.pi / 6)
print(r)
```

- 返回值是一个tuple(元组）！但是，在语法上，返回一个tuple可以省略括号，而多个变量可以同时接收一个tuple，按位置赋给对应的值
- 其实返回的还是一个值<img src="E:\GitT\Pic\image-20231212184317875.png" alt="image-20231212184317875" style="zoom:50%;" />

## 如果没有返回值：

- 函数执行完毕也没有`return`语句时，自动`return None`

## 函数的参数

### 函数的默认参数：

- 当函数有多个参数时，把变化大的参数放前面，**变化小的参数放后面**。变化小的参数就可以作为默认参数；可以降低调用函数的难度。
- 符合默认参数的，只需要提供其他参数信息；只有默认参数不符合的才需要提供更多信息
- Python函数在定义的时候，默认参数`L`的值就被计算出来了：**默认参数必须指向不变对象**

```python
def power(x, n = 2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5))
print(power(5,3))
```

### 可变参数

- 将参数作为列表或者元组传进来，为了更方便的传入加上*

- `*nums`表示把`nums`这个list的所有元素作为可变参数传进去
- 可变参数既可以直接传入：`func(1, 2, 3)`，又可以先组装list或tuple，再通过`*args`传入：`func(*(1, 2, 3))`

```python
def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
print(calc(1,2,3))
nums = [1,2,3]
print(calc(*nums))
```

### 命名关键字参数

- **命名关键字参数**需要一个**特殊分隔符`*`**，`*`后面的参数被视为命名关键字参数。
- 如果函数定义中已经有了一个可变参数，后面跟着的命名关键字参数就不再需要一个特殊分隔符`*`了：

```python
def person(name,age,*,city,job):
    print(name,age,city,job)
# 命名关键字参数需要显示命名
person('Jack',24,city='Beijing',job='Engineer')
```

### 关键字参数

- 即`**kw`,是一个dict类型的键值对
- 函数的调用者可以传入任意不受限制的**关键字参数**。至于到底传入了哪些，就需要在函数内部通过`kw`检查

### 参数的命名顺序：

- 参数定义的顺序必须是：必选参数、默认参数、可变参数、命名关键字参数和关键字参数
- 多种参数混合而成参数列表

```python
def mul(x,y=1,*numbers):
    result = 1
    for i in numbers:
        result = i * result
    return result * x * y
print(mul(5))
print(mul(5,6,7)) # x=5, y=6, numbers=(7,)，输出 5*6*7
print(mul(5,6,7,9))
```

