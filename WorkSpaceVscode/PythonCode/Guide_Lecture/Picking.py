import pickle
d = dict(name='Bob', age=20, score=88)
pickle.dumps(d)

f = open('dump.txt','rb')
d = pickle.load(f)
f.close()
print(d)

#将pyhton对象转化为JSON
import json
d1 = dict(name='Bob', age=20, score=88)
json.dumps(d1)