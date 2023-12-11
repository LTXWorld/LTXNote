classmates = ['Michael','Bob','Tracy']
lens = len(classmates)
print(classmates[-1])
#指定位置添加
classmates.insert(1,'Jack')
#从末尾添加
classmates.append('Adam')
print(classmates)
#从末尾删除
classmates.pop()
print(classmates)

classmates2 = ('Michael','Bob','Tracy')

L = [
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
    ['Adam', 'Bart', 'Lisa']
]
# 打印Apple:
print(L[0][0])
# 打印Python:
print(L[1][1])
# 打印Lisa:
print(L[2][2])