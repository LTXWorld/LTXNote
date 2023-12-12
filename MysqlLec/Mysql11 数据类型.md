# Mysql11 数据类型

## 整型

<img src="./../Pic/image-20231212210353857.png" alt="image-20231212210353857" style="zoom: 67%;" />

### 数据宽度：

- 可以设定**至少的显示宽度**，不会影响元数据的类型宽度
- 从8.0开始不推荐使用此方法

```mysql
CREATE TABLE test_int2(
f1 INT,
f2 INT(5),
f3 INT(5) ZEROFILL #零填充。显示宽度为5，当insert不足5位时，使用0填充；超过5位不管
)

INSERT INTO test_int2(f3)
VALUES(123),(123456);
```

## 浮点类型：

### 精度误差:

- 浮点数存在精度误差，避免使用等号直接判断两个数是否相等
- 开发中尽量使用定点数`DECIMAL`——底层中使用字符串去存储的，所以使用它。

```mysql
create table test_double2(
f1 double
);
Insert into test_double2
values(0.47),(0.44),(0.19);

select sum(f1)
from test_double2;#这里并不等于1.1
```

## 定点数类型：

### 语法

- M为精度、D为标度

```mysql
DECIMAL(M,D)
```

- 将上面的改为定点数，结果为1.1