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

print('END')