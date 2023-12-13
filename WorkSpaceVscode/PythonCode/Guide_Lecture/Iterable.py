from collections.abc import Iterable
isinstance('abc',Iterable)
print(isinstance(132,Iterable))

def findMinandMax(L):
    if L == []:
        return(None,None)
    maxValue = L[0]
    minValue = L[0]
    for i in  L:
        if i > maxValue:
            maxValue = i
    for j in L:
        if j < minValue:
            minValue = j
    return (maxValue,minValue)

print(findMinandMax([7]))