# Mysql09对数据库操作

## 1 创建数据库

```mysql
#创建数据库
create database mytest1;
create database mytest2 character set 'gbk';
#如果数据库本身存在，不会创建不会报错。
create database if not exists mytest3 character set 'utf8';
```



## 2 管理数据库

```mysql
#查看当前连接中的数据库有哪些
show databases;
#切换数据库
use mytest1;
#查看当前数据库中有哪些表
show tables;
#查看当前使用的数据库
select database() from dual;
#查看指定数据库中的表
show tables from mysql;
```

## 3 修改数据库

通常不会去修改，特别是不会去删除，因为删除操作不会回滚。

```mysql
#更改字符集
alter database mytest3 character set 'gbk';
#删除数据库
Drop database mytest1;
drop database if exists mytest1; 
```

# 对表的操作：

## 1 创建表（多种方式）：

```mysql
#方式一：直接创建
create table if not exists myemp1(#需要用户具有创建表的权限
id int,
emp_name varchar(15),
hire_date date
);
#方式二,基于现有创建新的，还能将别名作为新名称
create table myemp2
as
select employee_id,last_name,salary
From employees;
#创建表实现对表的完整复制
CREATE TABLE employees_copy
AS
SELECT *
FROM employees;
#实现复制，但不包括表数据
CREATE TABLE employees_copy2
AS 
SELECT *
FROM employees
WHERE 1=2;#只要创建一个绝对不成立的选择条件即可
```

## 2管理表

### 修改表：

- 对字段、表名进行修改

```mysql
#添加一个字段
alter table myemp1
add salary double(10,2);#2位小数，一共十位
#默认加在最后一个字段，后面可以指定after,first
alter table myemp1
add phone_number varchar(20) first;
#修改字段长度
ALTER TABLE myemp1
MODIFY emp_name VARCHAR(30);
#重命名字段
ALTER TABLE myemp1
CHANGE salary monthly_salary DOUBLE(10,2);
#删除一个字段
ALTER TABLE myemp1
DROP COLUMN email;
#重命名表
RENAME TABLE myemp1
TO myemp01;
```

- `TRUNCATE`清空表中数据，与`Delete From`操作进行区分:
- 前者不支持回滚操作；后者操作时别带where，可以回滚：<img src="./../Pic/image-20231204170847227.png" alt="image-20231204170847227" style="zoom:50%;" />
- 因为前者的commit不会被更改，直接提交了。

```sql
#清空表，删除表中的数据，但结构存在
TRUNCATE TABLE
employees_copy;
```

