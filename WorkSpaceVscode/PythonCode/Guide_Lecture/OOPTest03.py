class Animal(object):
    pass
#大类
class Mammal(Animal):
    pass
class Bird(Animal):
    pass

class RunnableMixIn(object):
    def run(self):
        print('Run')

class FlyableMixIn(object):
    def fly(self):
        print('Fly')
#各种动物
class Dog(Mammal, RunnableMixIn):
    pass
class Bat(Mammal, FlyableMixIn):
    pass
class Parrot(Bird,FlyableMixIn):
    pass
class Ostrich(Bird,RunnableMixIn):
    pass


