f = open('C:/Users/ASUS/Desktop/text.txt','r')
print(f.read())
f.close()

with open('C:/Users/ASUS/Desktop/text.txt','r') as f:
    print(f.read())

for line in f.readlines():
    print(line.strip())

f1 = open('C:/Users/ASUS/Desktop/text.txt','w')
f1.write('ltx')
f1.close()

with open('C:/Users/ASUS/Desktop/text.txt','a') as file:
    file.write('Additional content.\n')

from io import StringIO
f2 = StringIO()
f2.write('hello')
f2.write(' ')
f2.write('world')
print(f2.getvalue())
from io import StringIO
f3 = StringIO('hello!\nhi!\nGoodbye!')
while True:
    s = f3.readline()
    if s =='':
        break
    print(s.strip())

from io import BytesIO
f5 = BytesIO()
f5.write('中文'.encode('utf-8'))
print(f5.getvalue())