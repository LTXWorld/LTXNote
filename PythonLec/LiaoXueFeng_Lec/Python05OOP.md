# Python06OOP

## Class

- 注意到`__init__`方法的第一个参数永远是`self`，表示创建的实例本身，因此，在`__init__`方法内部，就可以把各种属性绑定到`self`，因为`self`就指向创建的实例本身
- 调用时不用传递`self`

## Private

- 在Python中，实例的变量名如果**以`__`开头**，就变成了一个私有变量（private）： 不能直接访问`__name`是因为Python解释器对外把`__name`变量改成了`_Student__name`
- 所以动态语言里这样的限制全凭自觉
- 在Python中，变量名类似**`__xxx__`的**，也就是以双下划线开头，并且以双下划线结尾的，是**特殊变量**，特殊变量是可以直接访问的

## 开闭原则:

对扩展开放：允许新增`Animal`子类；

对修改封闭：不需要修改依赖`Animal`类型的`run_twice()`等函数

## 与Java不同之处：

- 静态语言某方法传入的必须是父类的子类才可以，而动态语言只要拥有相同的方法就可以传入。
- 这就是动态语言的“鸭子类型”，它并不要求严格的继承体系，一个对象只要“看起来像鸭子，走起路来像鸭子”，那它就可以被看做是鸭子

## Python中的对象操作

### dir

- 如果要获得一个对象的所有属性和方法，可以使用`dir()`函数，它返回一个包含字符串的list

### 内置操作：

配合`getattr()`、`setattr()`以及`hasattr()`，我们可以直接操作一个对象的属性和方法；获取属性、设置属性、是否有某属性

# 高级OOP

## __slots__

用来限制实例的属性，防止动态语言过于动态，只能添加slots的属性

- `__slots__`定义的属性仅对当前类实例起作用，对继承的子类是不起作用的；除非在子类中也定义`__slots__`，这样，子类实例允许定义的属性就是自身的`__slots__`加上父类的`__slots__`

```python
class Student(object):
    __slots__ = ('name','age')#用tuple定义允许绑定的属性名称


s = Student()
s.name = 'Michael'
s.age = 25
# s.score = 99
class GraduateStudent(Student):
    pass
g = GraduateStudent()
g.score = 99
```

## @Property

为了不像java那样一直用setget逻辑，可以用类似属性这样简单的方式来访问类的变量。

- 我们在对实例属性操作的时候，就知道该属性很可能不是直接暴露的，而是通过getter和setter方法来实现的
- `@property`广泛应用在类的定义中，可以让调用者写出简短的代码，同时保证对参数进行必要的检查，这样，程序运行时就减少了出错的可能性

```python
class Student(object):
    #将get方法变为属性
    @property
    def score(self):
        return self._score
    #将set方法变为属性
    @score.setter
    def score(self,value):
        if not isinstance(value,int):
            raise ValueError('erro')
        if value < 0 or value > 100:
            raise ValueError('score must be')
        self._score = value

s = Student()
s.score = 60#在这里就可以不用getset了
s.score = 999
```

- 属性的方法名不要和实例变量重名，**通常属性名称前面会加一个_**

## 多重继承

通过多重继承，一个子类就可以同时获得多个父类的所有功能。

## MixIn

- MixIn的目的就是给一个类增加多个功能，这样，在设计类的时候，我们优先考虑**通过多重继承来组合多个MixIn的功能，而不是设计多层次的复杂的继承关系。**
- 而Java是不允许这样多重继承的。

```python
class Animal(object):
    pass
#大类
class Mammal(Animal):
    pass
class Bird(Animal):
    pass

class RunnableMixIn(object):
    def run(self):
        print('Run')

class FlyableMixIn(object):
    def fly(self):
        print('Fly')
#各种动物
class Dog(Mammal, RunnableMixIn):
    pass
class Bat(Mammal, FlyableMixIn):
    pass
class Parrot(Bird,FlyableMixIn):
    pass
class Ostrich(Bird,RunnableMixIn):
    pass



```

- 注意要继承的类得定义在继承的类之前。

## 定制类：

Python的class中还有许多这样有特殊用途的函数，可以帮助我们定制类。

### str():

- 为了输出更好看，类似于Java中的`toString`

```python
class Student(object):
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return 'Student object (name: %s)' %self.name
```

### iter

如果一个类想被用于`for ... in`循环，类似list或tuple那样，就必须实现一个`__iter__()`方法，该方法返回一个迭代对象

### getitem

将iter得到的迭代对象变成list那样可以通过下标取值

### getattr

- 使类本身并不存在的属性被调用时也成为可能
- 当调用不存在的属性时，比如`score`，Python解释器会试图调用`__getattr__(self, 'score')`来尝试获得属性，这样，我们就有机会返回`score`的值

```python
class People(object):
    def __init__(self):
        self.name = 'Michael'

    def __getattr__(self,attr):
        if attr == 'score':
            return 99
        raise AttributeError('\'Student\' object has no attribute \'%s\;' % attr)#在调用非name,score属性时会返回的
        #把一个类的所有属性和方法调用全部动态化处理了，不需要任何特殊手段。
p = People()
print(p.name)
print(p.abc)
```

### call

可以使一个实例直接使用实例名进行调用（类似于函数）

```python
class Map(object):
    def __init__(self,name):
        self.name = name

    def __call__(self):
        print('My name is %s' % self.name)
m = Map('Michael')
m()#直接调用了对象实例call方法使用
```

## 枚举类

`Enum`可以把一组相关常量定义在一个class中，且class不可变，而且成员可以直接比较。

```python
from enum import Enum

Month = Enum('Month',('Jan','Feb','Mar'))

for name,member in Month.__members__.items():
    print(name, '=>', member, ',', member.value)
```

## 元类

### type（）

Python解释器遇到class定义时，仅仅是*扫描一下class定义的语法*，然后**调用`type()`函数创建出class**。

`type()`函数既可以返回一个对象的类型，又可以创建出新的类型

要创建一个class对象，`type()`函数依次传入3个参数：

1. class的名称；
2. 继承的父类集合，注意Python支持多重继承，如果只有一个父类，别忘了tuple的单元素写法；
3. class的方法名称与函数绑定，这里我们把函数`fn`绑定到方法名`hello`上。

```python
def fn(self, name ='world'):
    print('Hello, %s.' % name)
Hello = type('Hello',(object,),dict(hello=fn))
h = Hello()

h.hello()
```

### metaclass

- **先定义metaclass，就可以创建类，最后创建实例**;

- metaclass允许你创建类或者修改类。换句话说，你可以把类看成是metaclass创建出来的“实例”

