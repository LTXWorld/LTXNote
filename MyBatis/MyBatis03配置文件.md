## 核心配置文件XML文件详解

### environments标签

可以配置多个环境，每个环境都有其id；（不同环境代表着不同数据库）

**一个环境对应一个`SqlSessionFactory`对象**；`environments`标签有默认环境配置

```java
//两种调用数据库（环境）的方式，第一个使用默认环境，第二个使用指定环境id来获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream(""));


        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream(""), "powernode");
```

environment中的其他标签：

- `transactionManager`标签，配置事务管理器：`jdbc or Managed`

- `dataSource`标签，为程序提供连接**Connection对象**（这样的都叫做数据源）实际上是一套规范，由JDK规定的。

  - 常见的数据库连接池：阿里的Druid，dbcp；**连接池中保存连接对象，每一次连接都从池中拿**；数量可控，效率高。
  - Type有`Pooled,Unpooled,JNDI`：使用mybatis自己的连接池，每次都会创建新的连接对象，使用第三方的连接池。不同的Type下的属性都不一样，例如*连接数量，连接时间，空闲数量*等。
  - 连接池当中的参数配置根据业务情况而定，配置十分重要。 

- properties标签：配置多个属性，以属性名和属性值成对出现。常用的方式是将配置信息放在配置文件中，在XML文件中的属性标签下使用`resource`来引用

  - `<properties resource = "jdbc.properties"/>`

- Mappers标签：可以有多个Mapper，通过核心配置文件来找到sql映射文件
