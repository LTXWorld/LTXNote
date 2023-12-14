def add(x, y, f):
    return f(x) + f(y)

print(add(-5,-4,abs))

def f(x):
    return x * x
r = map(f,[1,2,3,4,5,6,7,8,9])
print(list(r))

L1 = list(map(str,[1,2,3,4,5,6]))
print(L1)

from functools import reduce

DIGITS = {'0' : 0, '1' : 1, '2': 2, '3': 3, '4': 4, '5' : 5,'6' : 6,'7': 7,'8':8,'9': 9}
def str2int(s):
    def fn(x,y):
        return x * 10 + y#将y拼接到x后面
    
    def char2num(s):
        return DIGITS[s]
    return reduce(fn,map(char2num,s))

def _odd_iter():
    n = 1
    while True:
        n = n + 2
        yield n

def _not_divisible(n):
    return lambda x: x % n > 0

def primes():
    yield 2
    it = _odd_iter()
    while True:
        n = next(it)
        yield n
        it = filter(_not_divisible(n), it)

for n in primes():
    if n < 1000:
        print(n)
    else:
        break

print(sorted(['bob','about','Zoo','Credit'],key=str.lower,reverse=True))

def lazy_sum(*args):
    def sum():
        ax = 0
        for n in args:
            ax = ax + n
        return ax
    return sum

def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i * i
        fs.append(f)
    return fs
f1,f2,f3 = count()

def inc():
    x = 0
    def fn():
        nonlocal x#可以对外层局部变量赋值
        x = x + 1
        return x
    return fn
f = inc()
print(f())