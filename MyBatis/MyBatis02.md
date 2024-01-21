## MyBatis入门程序

## 配置IDEA

使用Maven构建项目,设置相关的配置文件路径

![image-20240118163847305](../Pic/image-20240118163847305.png)

新建模块，设置相应坐标。

注意，src/main/resources目录,此目录中的资源等同于放在类的根路径下。

## 初始步骤

1. 设置打包方式
2. 引入依赖：mybatis依赖和mysql驱动依赖
3. 编写mybatis核心配置文件.xml,一般命名为`mybatis-config.xml`,一般放在类的根路径下（即resources下）;通过此文件创建一个重要的对象：SqlSessionFactory
   - `mybatis-config.xml`核心配置文件配置数据库信息，一般只有一个
   - `XXXMapper.xml`配置文件一般一个表一个，专门来编写SQL语句
4. 编写XXXmapper.xml配置文件，一般也放在resources目录下：<img src="../Pic/image-20240120095756539.png" alt="image-20240120095756539" style="zoom:50%;" />
5. 在核心配置文件中mapper的resources下关联想要的mapper文件；*自动会从根路径下查找文件。*
6. 编写Mybatis程序（即编写java程序，连接数据库做crud）
	- 负责执行sql语句的对象就是`SqlSession`，是java程序和数据库之间的一次会话；而Session需要由`SqlSeesionFactory`对象来获取（一个数据库一个，工厂生产）
	- 由SqlSessionFactoryBuilder对象的build方法获得工厂对象

```java
public static void main(String[] args) throws Exception {
        //获取builder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取Factory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");//默认从类的根路径查找资源
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);//输入流指向核心配置文件
        //获取session对象，以此来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句,返回影响数据库表中的记录条数
        int count = sqlSession.insert("insertCar");//传入sql语句的id
        System.out.println(count);
        //手动提交到数据库中，进行更新
        sqlSession.commit();
    }
```

### 深度剖析Mybatis的事务管理机制

在上面那段代码里，我的sout打印没有出问题，反倒是commit并没有真正提交到我的数据库中，直到我加入了异常捕获`try-catch`之后才得以成功更新。

```java
SqlSession sqlSession = sqlSessionFactory.openSession();
try {
    // 执行sql语句
    int count = sqlSession.insert("insertCar");
    System.out.println(count);
    // 提交事务
    sqlSession.commit();
} catch (Exception e) {
    sqlSession.rollback(); // 发生异常，回滚事务
    throw e;
} finally {
    sqlSession.close(); // 最终关闭会话
}
```

提供了两种事务管理机制：<img src="../Pic/image-20240120105801621.png" alt="image-20240120105801621" style="zoom:50%;" />

- JDBC
- MANAGED

<img src="../Pic/image-20240120110200422.png" alt="image-20240120110200422" style="zoom:50%;" />

对于获取sqlSession对象那里，如果执行`SqlSession sqlSession = sqlSessionFactory.openSession(true)`表示**没有开启事务**。因为不会去执行`conn.setAutoCommit(false)`;在JDBC事务中，没有执行刚才那段代码那么autoCommit就是true，只要执行任意一条DML语句就会提交一次。（我们建议还是要开启事务）

- 只要自动提交机制是true即意味着没有事务。
