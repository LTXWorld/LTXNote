# Mysql 03 运算符

## 1 算术运算符：

- 在mysql中，加法**没有连接字符串的作用**，会将值进行**隐式转换**（转换规则是从字符串的开始部分开始，尝试找到任何数值字符，直到遇到第一个非数值字符。）；如果不能转换的话将其视作数值0

```sql
SELECT 100 + '1'
FROM DUAL; # 输出101
SELECT '1' + 'x'
FROM DUAL; # 输出1,因为x里面没有任何数值字符
```

- 分母如果为0，结果为`null`
- 取模的符号看**前面的**被模数

## 2 比较运算符

### 符号：

- 等于号规则：等式两边只要有数值，都会转换为数值比较；等式两边如果没有数值（全是字符串）就比较字符串；**只要有`null`参与，结果就为`null`**
- *安全等于号*`<=>`与等于的唯一区别在于可以对`null`进行判断
- 不等于符号`<> !=`两种写法

### 具体的关键字：

- 对`null`的判断：` is null     is not null     ISNULL()`前两者很常用，最后的没有空格的是一个函数形式
- 最值：`LEAST()  GREATEST()`
- 区间查找（包含左右边界）
- 离散值的查找：`in(set)  not in(set)`
- 模糊查找：`LIKE（%XXX%)`；%代表着*零个或多个字符*；如果要**精确个数，使用下划线_，代表一个不确定的字符**；注意转义字符\的使用

```sql
# 查询部门号为10，20，30部门的员工
SELECT last_name,salary,department_id
FROM employees
WHERE department_id IN (10,20,30);
SELECT salary
FROM employees
WHERE salary NOT IN (6000,7000,8000);
# 模糊查找
SELECT last_name
FROM employees
WHERE last_name LIKE '%a%';
# 既包含a又包含e
SELECT last_name 
FROM employees
WHERE last_name LIKE '%a%e%' OR last_name LIKE '%e%a%';
#_代表一个不确定的字符
SELECT last_name
FROM employees
WHERE last_name LIKE '__a%';
```

## 3 逻辑操作符

- 注意异或运算符`XOR`;`a XOR b`追求的是一个“异”，需要左右两边的真假不同
- `AND`优先级高于`OR`

## 4位操作符