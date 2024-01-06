CREATE database dbtest2;
use dbtest2;

CREATE TABLE dept(
dept_id INT PRIMARY key auto_increment,
dept_name varchar(20)
);

CREATE table emp(
emp_id int primary key auto_increment,
emp_name varchar(20) unique,
dept_id int,
constraint emp_dept_id_fk foreign key(dept_id) references dept(dept_id)
);
CREATE table book2(
book_id int,
book_name varchar(100),
authors varchar(100),
info varchar(100),
comment varchar(100),
year_publication year,
index idx_bname(book_name)
);

show CREATE table book2;
show index from book2;

SELECT * from book2 
WHERE book_name = "Mysql";//有索引速度会加快

DROP table book;

