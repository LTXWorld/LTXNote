class Student(object):
    def __init__(self, name):
        self.name = name

    def __str__(self):
        return 'Student object (name: %s)' %self.name
    
print(Student('Michael'))

class People(object):
    def __init__(self):
        self.name = 'Michael'

    def __getattr__(self,attr):
        if attr == 'score':
            return 99
        raise AttributeError('\'Student\' object has no attribute \'%s\;' % attr)
p = People()
print(p.name)
print(p.abc)

class Map(object):
    def __init__(self,name):
        self.name = name

    def __call__(self):
        print('My name is %s' % self.name)
m = Map('Michael')
m()#直接调用了对象实例