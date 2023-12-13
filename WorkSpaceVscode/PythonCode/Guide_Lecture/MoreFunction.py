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
