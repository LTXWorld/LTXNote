import math
def my_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x > 0:
        return x
    else :
        return -x
def nop():
    pass

def move(x,y,step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx,ny

x,y = move(100,100,60,math.pi / 6)
print(x,y)

r = move(100,100,60,math.pi / 6)
print(r)

def quadratic(a,b,c):
    x1 = (math.sqrt(b * b - 4 * a * c) - b) / (2 * a)
    x2 = (math.sqrt(b * b - 4 * a * c) + b) / (2 * a)
    return x1,x2

print('quadratic(2,3,1) = ', quadratic(2,3,1))
print('quadratic(1,3,-4) = ', quadratic(1,3,-4))

if quadratic(2,3,1) != (-0.5,-1.0):
    print('erro')
elif quadratic(1,3,-4) != (1.0,-4.0):
    print('erro')
else:
    print('OK')

def power(x, n = 2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5))
print(power(5,3))

def calc(*numbers):
    sum = 0
    for n in numbers:
        sum = sum + n * n
    return sum
print(calc(1,2,3))
nums = [1,2,3]
print(calc(*nums))

def person(name,age,*,city,job):
    print(name,age,city,job)

person('Jack',24,city='Beijing',job='Engineer')

def mul(x,y = 1,*numbers):
    result = 1
    for i in numbers:
        result = i * result
    return result * x * y
print(mul(5))
print(mul(5,6,7))
print(mul(5,6,7,9))