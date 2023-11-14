# Mysql05 多表查询

## 概念：

- 笛卡尔积（交叉连接）：会得到所有的交叉可能
- 多表的连接条件：其实就是看两个表靠什么字段连接起来的

```sql
#加上连接条件
SELECT employee_id,department_name
FROM employees,departments
where employees.`department_id` = departments.`department_id`;
```



- 注意，如果查询字段中字段存在于多个表中，需要明确指明你要的是哪一个表中的该字段；**从优化的角度，建议每个列前都指明其所在的表**
- 如果有n个表进行多表连接，*至少得有n-1个连接条件*

## 多表查询的分类：（三个角度）

### 等值连接和非等值连接：

- 上面写过的连接条件都是等值连接（即等号），非等值连接把等号换成一些范围条件即可

```sql
SELECT e.last_name,e.salary,j.grade_level
FROM employees e,job_grades j
WHERE e.salary BETWEEN j.lowest_sal AND j.highest_sal;# 在区间之内，非等值连接
```

### 自连接和非自连接：

- 通常写的都是非自连接，自连接是重复利用同一张表的不同字段进行连接。

```sql
# 查询员工姓名及其管理者的id和姓名,将第二张员工表看作管理者表
select e.last_name,e.employee_id,mag.employee_id,mag.last_name
from employees e,employees mag
where e.manager_id = mag.employee_id;
```

### 内连接和外连接（难）：

- 内连接：就是平常用的连接
- 外连接：不仅返回内连接的查询结果，还会返回条件不匹配的结果（比如有的为null）——一般会出现**所有的这一关键词**
- 外连接分为左外连接、右外连接、满外连接
- 当需要将*右边多出来（不匹配）的行输出，就要进行左外连接*<img src="E:\GitT\Pic\image-20231114195908300.png" alt="image-20231114195908300" style="zoom:50%;" />

#### 如何使用外连接：

- 之前的语法都基于sql92语法

- sql92语法中：在较短的那张表使用加号。`(+)`但是Mysql不再支持

- sql99语法中：对于**内外连接都有新的要求**

  - 内连接：JOIN加入一个表，ON后面设置连接的条件。

  ```sql
  #SQL99语法使用JOIN ...ON的方式实现
  select last_name,department_name,city
  from employees e join departments d
  on e.department_id = d.department_id
  join locations l
  on d.location_id = l.location_id;
  ```

  - 三种外连接（就是在join之前加上`left right full`)——但Mysql不支持sql99的满外连接

  ```sql
  #左外连接
  SELECT last_name,department_name
  FROM employees e LEFT JOIN departments d
  ON e.department_id = d.department_id;
  #右外连接
  SELECT last_name,department_name
  FROM employees e RIGHT JOIN departments d
  ON e.department_id = d.department_id;
  #满外连接
  SELECT last_name,department_name
  FROM employees e FULL JOIN departments d
  ON e.department_id = d.department_id;
  ```

  

### sql99语法里的其他JOIN语法：

- 总共七种连接，上面已经有了四种：

<img src="E:\GitT\Pic\image-20231114195959651.png" alt="image-20231114195959651" style="zoom: 33%;" />

