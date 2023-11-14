# Mysql04 排序与分页

## 排序

### 概念：

- 如果没有使用排序操作，默认情况下查询的顺序是你当时添加的顺序

### 操作：

- 使用`ORDER BY`关键字进行排序操作，后面加上`DESC  ASC`表示降序和升序；如果不加默认为升序
- 注意，当与`WHERE`联用的时候，一定是`WHERE`在前，靠近`FROM`

### 多列排序：

- 排完一次序之后还想对第一次排的顺序一样的进行再排序——在后面加上再排序就行

```sql
# 显示员工信息，按照id降序再按照salary地升序排序
select employee_id,salary,department_id
from employees
order by department_id desc,salary asc;
```

## 分页

### 概念：

- app里的第几页第几页，设置切换的时候都是分页操作；提升效率，减少空间损耗

### 操作：

- 使用`LIMIT`操作：**LIMIT 偏移量 本页显示多少条数据**；特殊的，偏移量为0时可省略——*8.0中新特性，添加了`OFFSET`关键字，其前面为数据数，后面为偏移量*
- 公式：每页使用`pageSize`条记录，则设置为`LIMIT (pageNo - 1) * pageSize, pageSize`
- 先写where再写order by 最后写limit

