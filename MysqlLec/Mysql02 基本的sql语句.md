# Mysql02 基本的sql语句
## SQL概述
- SQL规范虽然都要遵循，但是不同公司会有自己的特色（Mysql和Oracle）
- 三条主线：<img src="../../../GitT/Pic/image-20231111195235284.png" alt="image-20231111195235284" style="zoom:50%;" />

- DDL是对表整体的操作，DML主要都是进行DML增删改查，控制语言用来*控制操作（事务）*

## SQL语言的规则规范
- windows对大小写不敏感，所以Mysql在windows下对大小写也不敏感；而linux区分所以有些敏感
- 建议遵守：<img src="../../../GitT/Pic/image-20231111202151479.png" alt="image-20231111202151479" style="zoom:50%;" />

## SQL操作：
### 导入外部数据库：
- 从命令行：`source 文件绝对路径名称`
- 从图形化界面工具，例如sqlyog：工具-执行sql脚本-选中某个.sql文件

### 基本的SELECT语句
- `select  字段1字段2 from 字段所在的表的表名`，注意`dual`为一个关键字代表着伪表
- `select * from ...`星号代表了全部的字段（*所有的列*）

#### 列（表）的别名：
- 三种写法：as:alias(别名），可以省略;列的别名也可以用一对双引号引起来；也可以用空格隔开
- 注意，别名可以与`ORDER BY`联用，但是不能与`WHERE`联用，因为底层的**运行顺序where在select之前，而别名在select里面**。
- 可以给表起别名，在select和where中使用别名更简洁（多表查询）——**如果已经起了别名，则必须都使用别名**

```sql
select emp.employee_id,dept.department_name,emp.department_id
from employees emp,department dept#起的别名
where emp.`department_id` = dept.department_id;
```



#### 删除重复的行
- 使用`distinct`关键字

```sql
SELECT DISTINCT department_id
FROM employees;
```
#### 空值是否能参与运算
- null不等于`0,''`

```sql
select employee_id,salary "月工资",salary * (1+commission_pct) * 12 "年工资"
from employees;
```

#### 着重号``
- 当表名或者字段名与关键保留字冲突重名时，加上着重号。

```sql
select * from `order`;
```
#### 使用常数查询
- 会根据后面的非常数来确定常数应该有几行
```sql
select 123,employee_id,last_name
from employees;
```

### 显示表结构：

- 显示表中字段的详细信息
- <img src="../../../GitT/Pic/image-20231111214624872.png" alt="image-20231111214624872" style="zoom:50%;" />

```sql
describe employees;
desc employees;
```

### 过滤数据：

- 选择满足某些条件的数据，使用`where`关键字；注意书写的规范，`from`写在下一行，后面条件继续下一行
- 一定得声明在`from`的后面（**紧挨着from**）

```sql
SELECT * 
FROM employees
WHERE last_name = 'King';
```

