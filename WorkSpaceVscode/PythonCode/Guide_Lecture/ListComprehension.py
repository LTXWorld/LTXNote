
L = [x*x for x in range(1,11) if x % 2 == 0]
print(L)
L2 = [m + n for m in 'ABC' for n in 'XYZ']
print(L2)
import os
L3 = [d for d in os.listdir('.')]
print(L3)

d = {'x': 'A','y':'B','z':'C'}
for k,v in d.items():
    print(k,'=',v)
L4 = [k + '=' + v for k,v in d.items()]
print(L4)
L5 = ['Hello','World','IBM','Apple']
[s.lower() for s in L5]

L6 = ['Hello', 'World', 18, 'Apple', None]
L7 = [s.lower() for s in L6 if isinstance(s, str)]
print(L7)


g = (x * x for x in range(10))
for n in g:
    print(n)

def fib(max):
    n,a,b = 0,0,1
    while n < max:
        yield b
        a, b = b, a + b
        n = n + 1
    return 'done'

f = fib(6)
print(f)

for n in fib(6):
    print(n)