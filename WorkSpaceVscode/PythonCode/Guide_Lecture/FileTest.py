import os
print(os.name)
print(os.environ)
print(os.environ.get('PATH'))
print(os.path.abspath('.'))
#在某目录下创建一个新目录
os.path.join('/Users/michael','testdir')
os.mkdir('')
os.rmdir('')

import os
print([x for x in os.listdir('.') if os.path.isdir(x)])