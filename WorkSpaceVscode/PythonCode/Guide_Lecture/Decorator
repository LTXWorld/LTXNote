
import functools
def log(func):
    @functools.wraps(func)
    def wrapper(*args, **kw):
        print('call %s():' % func.__name__)
        return func(*args, **kw)#在这里返回实际的函数功能
    return wrapper

@log
def now():
    print('2015-3-25')

now = log(now)

def log(text):
    def decorator(func):
        def wrapper(*args, **kw):
            print('%s %s() :' %(text,func.__name__))
            return func(*args, **kw)
        return wrapper
    return decorator