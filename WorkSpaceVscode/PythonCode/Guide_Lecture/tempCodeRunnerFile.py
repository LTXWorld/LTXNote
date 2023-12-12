def mul(x,y = 1,*numbers):
    result = 1
    for i in numbers:
        result = i * result
    return result * x * y
print(mul(5))
print(mul(5,6,7))
print(mul(5,6,7,9))