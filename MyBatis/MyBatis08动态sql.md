# 动态SQL

根据前端提出的请求不同，后端呈现出不同的随着变化的SQL语句。

## 标签

### if标签

```xml
    <select id="selectIfMulti" resultType="Car">
        select * from t_car where
        <if test="brand != null and brand !=''">
            and brand like "%"#{brand}"%"
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            and guide_price > #{guidePrice}
        </if>
        <if test="carType != null and carType !=''">
            and car_type = #{carType}
        </if>
    </select>
```

- test属性是必须的，内部是一条语句值是false或者true
- 如果为true，标签中的sql语句就会拼接到上面的sql语句
- 如果使用了@Param注解，占位符中必须与其指定参数名称相同；如果没有使用可以参照多参数param1 arg0
- 动态sql中不能使用`&&`,只能用and

### where标签

<img src="../Pic/image-20240303083126815.png" alt="image-20240303083126815" style="zoom:50%;" />

将if标签包裹，其强大特性

- 如果where所有条件为空时，不会生成where子句
- 会自动调整条件**前面的**`and or`关键字（而不是语句后面的and和or）

### trim标签

```xml
<select id="selectByMultiConditionWithTrim" resultType="Car">
        select * from t_car
        <trim prefix="where" suffixOverrides="and|or">
            <if test="brand != null and brand !=''">
                 brand like "%"#{brand}"%" and
            </if>
            <if test="guidePrice != null and guidePrice != ''">
                 guide_price > #{guidePrice} or
            </if>
            <if test="carType != null and carType !=''">
                 car_type = #{carType}
            </if>
        </trim>
    </select>
```

- prefix加前缀；suffix加后缀
- prefixOverrides删除前缀；suffixOverrides删除后缀
- 这些操作都是基于在最外面的SQL语句后面拼接语句。

### set标签

主要使用在update语句中，用来生成set关键字，同时去掉最后的逗号

与if标签联用可以保证只更新不为空的部分，空的部分不会更新

### choose when otherwise

等同于if-else if-else

```xml
<choose>
	<when test=""></when> 相当于else if
  <when test=""></when>
  <otherwise test=""></otherwise> 相当于最后的else
</choose>
```

### For each标签

一般用来循环删除和循环添加

```xml
    <delete id="deleteByIds">
        delete from t_car where id in (
            <foreach collection="ids" item="id" separator="," >
                #{id}
            </foreach>
            )
    </delete>
```

- collection指定数组或者集合
- item代表数组或者集合中的元素：与占位符中的一致。
- separator:循环之间的分隔符
- open：拼接的所有sql语句最前面以何开始；close以何结束

批量插入