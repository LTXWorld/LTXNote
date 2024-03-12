# 手写框架

## 回顾反射机制 

获取类-获取方法-调用方法（四要素）-

```java
Class<?> clazz = Class.forName("com.ltx.reflect.someService");
Method dosomeMethod = clazz.getDeclaredMethod("dosome", String.class, int.class);//后两个表征不同方法重载中的参数来区分方法
//哪个对象，哪个方法，什么参数，返回什么
Object obj = clazz.newInstance();
Object retValue = doSomeMethod.invoke(obj, "李四",250);//invoke返回值就是方法返回值

//根据属性名获取属性类型,先获取属性，再获取属性类型。
Field field = clazz.getDeclaredField(propertyName);
field.getType;
```

## 手写

先在框架的使用者角度准备一些类和配置Bean文件

再仿照之前使用时采用反射机制进行编写框架代码。

- 注意使用map集合存放Bean对象
- 注意使用dom4j来解析配置文件(SAXReader ->xml)
- 注意实例化Bean之后提前曝光。

# 注解开发

