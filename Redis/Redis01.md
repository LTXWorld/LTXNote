# Redis01

## 认识Redis

特点

- 键值对类型
- 单线程
- 基于内存，并且支持持久化
- 主从集群，分片集群

## 安装Redis

1、在官网上下载相关文件

2、进入Redis目录中编译Redis

- 使用`make`指令进行编译

3、运行Redis服务器和客户端

- `src/redis-server `
- `src/redis-cli`

4、安装到系统路径



## 指定配置启动

- 修改bind，任意IP访问

- daemonize改为yes后台运行 

- 设置密码requirepass
- 默认为16个库

## 数据结构

数据类型

Key一般都是String类型，Value有多种类型。

<img src="/Users/lutao/GitT/Pic/image-20240402120613553.png" alt="image-20240402120613553" style="zoom:50%;" />

## 通用命令

使用`help[command]`来获取某个命令的具体用法

<img src="/Users/lutao/GitT/Pic/image-20240402123243053.png" alt="image-20240402123243053" style="zoom:50%;" />

有效期非常关键，防止数据堆积。 

对于**不同的Value类型**有不同的操作方法。 

### KEY的结构

使用[项目名]:[业务名]:[类型]:[id]来区分

### String类型

字符串、int、float都是String类型

<img src="/Users/lutao/GitT/Pic/image-20240402141756876.png" alt="image-20240402141756876" style="zoom:50%;" />

<img src="/Users/lutao/GitT/Pic/image-20240402143056529.png" alt="image-20240402143056529" style="zoom:50%;" />

*将对象序列化为JSON字符串后存储。*

### Hash类型

对象中的每个字段独立存储，方便单个字段操作

<img src="/Users/lutao/GitT/Pic/image-20240402144132328.png" alt="image-20240402144132328" style="zoom:50%;" />

<img src="/Users/lutao/GitT/Pic/image-20240402150017699.png" alt="image-20240402150017699" style="zoom:50%;" />

### List结构

Value处结构为双向链表LinkedList

### Set类型

Value作为集合，HashSet无序。

### SortedSet类型

Value作为**可排序集合**

<img src="/Users/lutao/GitT/Pic/image-20240402153440101.png" alt="image-20240402153440101" style="zoom:50%;" />

所有的排名默认升序，如果降序的话在z后面加上REV 

# Redis02JAVA客户端下的Redis

##  Jedis

引入依赖-建立连接-使用-释放连接 

但是线程不安全，所以建议使用Jedis连接池代替直连——JedisConnectionFactory，即连接池会生产Jedis连接

## SpringDataRedis

### RedisTemplate

 <img src="/Users/lutao/GitT/Pic/image-20240402163142682.png" alt="image-20240402163142682" style="zoom:50%;" />

可以分Value类型操作。

### 自定义RedisSerializer序列化

存取数据（无论字符串还是对象，都会进行序列化）

**自动序列化与反序列化。**

需要在配置Bean中定义好Key的序列化（String），Value的序列化（json）；*否则默认使用JDK内部的序列化工具，不会将其序列化成想要的类型。*

<img src="/Users/lutao/GitT/Pic/image-20240402190004288.png" alt="image-20240402190004288" style="zoom:50%;" />

（反序列化依靠这个class）但是耗费空间。

###  StringRedisTemplate

全部应用于字符串，如果是java对象则需要**手动序列化（利用json的ObjectMapper）与反序列化**。