class Student(object):
    __slots__ = ('name','age','score')#用tuple定义允许绑定的属性名称
    def get_score(self):
        return self._score
    def set_score(self,value):
        if not isinstance(value,int):
            raise ValueError('score must be an integer')
        if value < 0 or value > 100:
            raise ValueError('score must between 0 ~ 100!')
        
        self._score = value

s = Student()
s.name = 'Michael'
s.age = 25
# s.score = 99
class GraduateStudent(Student):
    pass
g = GraduateStudent()
g.score = 99

