class Student(object):
    #将get方法变为属性
    @property
    def score(self):
        return self._score
    #将set方法变为属性
    @score.setter
    def score(self,value):
        if not isinstance(value,int):
            raise ValueError('erro')
        if value < 0 or value > 100:
            raise ValueError('score must be')
        self._score = value

s = Student()
s.score = 60
s.score = 999