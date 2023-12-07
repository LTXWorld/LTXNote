# Mysql10 对数据的增删改DML

`Insert\Update\Delete`增 改 删 

## 1 插入数据

- 两种方式插入，一种从无到有，一种从别处借鉴

```mysql
#方式一：逐一添加
#1没有指明添加字段必须按照声明顺序
insert into emp1
values (1,'Tom','2023-12-5',3540);
#2指明要添加的字段,可以不用写全
insert into emp1(id,hire_date,salary,`name`)
values(2,'1999-09-09',5000,'Jerry');
Insert into emp1(id,salary,`name`)
values(3,4500,'shk');
#3同时插入多条记录
insert into emp1(id,`name`,salary)
values
(4,'Jim',5000),
(5,'ZZZ',7000);

#方式二：将查询结果插入列表当中
insert into emp1(id,`name`,salary,hire_date)
select employee_id,last_name,salary,hire_date
from employees
where department_id in(60,70);
```

## 2 更新数据(修改)

` UPDATE...SET...WHERE...`

```mysql
#更新数据（修改）,如果不加where就成了批量修改
UPDATE emp1
SET hire_date = CURDATE()
WHERE `name` = 'ZZZ';
#同时修改多个字段
UPDATE emp1
SET hire_date = CURDATE(),salary = 6000
WHERE id = 4;
```

## 3 删除数据

```mysql
#删除数据 DELETE FROM ... WHERE...
delete from emp1
where id = 1;
```

## 新特性：计算列

```mysql
#计算列,c作为计算列
create table test1(
a int,
b int,
c int generated always as(a + b) virtual
);
insert into test1(a,b)
values(10,20);
select * from test1;
```

## 实战案例：

```mysql
CREATE DATABASE IF NOT EXISTS test01_library CHARACTER SET 'utf8';
USE test01_library;
CREATE TABLE books(
id INT,
`name` VARCHAR(50),
`authors` VARCHAR(100),
price FLOAT,
pubdate YEAR,
note VARCHAR(100),
num INT
);
DESC books;

SELECT * FROM books;

INSERT INTO books
VALUES();
```

