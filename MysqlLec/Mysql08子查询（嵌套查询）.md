# Mysql08子查询（嵌套查询）

## 概念引入

- 处理多个条件时为了提高数据库的查找效率使用。
- 所有子查询都可以用自连接来实现

```sql
#谁的工资比albert的高
#自连接的不等值连接
select e2.last_name,e2.salary
from employees e1
join employees e2 on e2.salary > e1.salary
where e1.last_name = 'Abel';
#子查询
select last_name,salary
from employees
where salary >(
		select salary
		from employees
		where last_name = 'Abel'
		);
```

- 名词：外查询（或主查询）、内查询（子查询）
- **注意：**子查询要放在*括号内*，放在比较条件的右侧；单行操作符对应单行子查询（多行对应多行）

### 写子查询的技巧

- 从里往外写：
- 从外往里写：

## 分类

### 单行vs多行

- 只输出一个结果，叫做单行子查询；不止一个输出结果，叫做多行

### 相关vs不相关

- 里外的查询是否有相关性——上面的例子就不相关，每次都是与一个跟`salary`无关的常数去比，如果换成“工资大于**本部门**平均工资”，就具有相关性了。
- 不相关子查询：独立运行，结果可以用在主查询中，但不依赖于主查询的任何行。
- 相关子查询：每一行外部查询都可能会运行一次，**因为内部查询的结果依赖于外部查询当前行的数据**。

### 单行实例：

- <img src="E:\GitT\Pic\image-20231129200827521.png" alt="image-20231129200827521" style="zoom:50%;" />

```sql
#单行子查询题目
#查询工资大于149号员工工资员工信息
select employee_id,last_name,salary
from employees
where salary >(
		SELECT salary
		FROM employees
		WHERE employee_id = 149
		);
#返回id与141号员工相同，salary比143号员工多的员工信息
select last_name,job_id,salary
from employees
where job_id =(
		SELECT job_id
		FROM employees
		WHERE employee_id = 141
		)
and salary >(
		SELECT salary
		FROM employees
		WHERE employee_id = 143
		);

# 返回公司工资最少的员工信息
select last_name,job_id,salary
from employees
where salary =(
		SELECT MIN(salary)
		FROM employees
		);
#查询与141号员工id号相同的其他员工 的各种信息
select employee_id,manager_id,department_id
from employees
where manager_id =(
		    select manager_id
		    from employees
		    where employee_id = 141
		   )
and department_id =(
		    select department_id
		    from employees
		    where employee_id = 141
		    )
and employee_id <> 141; #注意这里不等于号的写法		
#Having中使用子查询
#查询最低工资大于50号部门最低工资的部门id和最低工资
select department_id,min(salary)
from employees
where department_id is not null
group by department_id
having min(salary) >(
		     select min(salary)
		     from employees
		     where department_id = 50
		     );
# 与case(if)流程控制联用
#显示员工的信息，其中若员工的id与locid为1800的id相同
#则location为canada，其余为usa
select employee_id,last_name,case department_id when (SELECT department_id FROM departments WHERE location_id = 1800) then 'Canada'
						 else 'USA' end "location" 
from employees;

```

### 多行实例：

- <img src="E:\GitT\Pic\image-20231129205558672.png" alt="image-20231129205558672" style="zoom:50%;" />
- `ANY`**只要存在一个**就可以满足条件

```sql
#多行子查询
#返回其他jobid中比jobid为it部门任一工资低的员工的员工号
select employee_id,last_name,job_id,salary
from employees
where job_id <> 'IT_PROG'
and salary < any(
			SELECT salary
			FROM employees
			WHERE job_id = 'IT_PROG' 
		 );
#如果把任一改为所有
SELECT employee_id,last_name,job_id,salary
FROM employees
WHERE job_id <> 'IT_PROG'
AND salary < all(
			SELECT salary
			FROM employees
			WHERE job_id = 'IT_PROG' 
		 );		

#查询平均工资最低的部门id
#方式一，使用到了from中的子查询,且大体上是单行子查询
select department_id
from employees
group by department_id
having avg(salary) =(
			SELECT MIN(avg_sal)
			FROM(
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
				)t_dept_avg_sal
		       );
#方式二,小于等于全部的就是小于等于最小的了。自己本来就在里面所以自己是最小的
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary) <= all(
				SELECT AVG(salary) avg_sal
				FROM employees
				GROUP BY department_id
		       );

```

- 对于方式一中在`From`中使用子查询，我们将AVG(salary) 结果命别名 avg_sal，将整个SELECT结果看作一张*临时的表*，**注意与FROM联用时要为其起别名**t_dept_avg_sal；特殊的是，这个临时表此时只有一个单一的列  avg_sal,外面在对这个单一的列进行MIN——最终得到*部门分组下的各部门的最低平均工资*
- 在 SQL 中，子查询的结果集必须有别名，以便外部查询可以正确地引用它。你可以将子查询想象为一个没有物理存在的表，而这个表需要一个名字以供外部查询引用。

### 应用注意：

- 可以在循环控制`case when then else end`当中使用；还可以在`from`  ` Having`当中使用子查询