# Bean的初始化方式

## 1XML方式

在XML文件中使用Beans标签进行配置

```xml
<beans>
    <bean id="myBean" class="com.example.MyBean" />
</beans>

```

使用时使用上下文来进行获取。

```java
ApplicationContext context = new ClassPathXmlApplicationContext("path/to/applicationContext.xml");
MyBean myBean = context.getBean(MyBean.class);
```



## 2XML+注解配置

元素指示Spring在指定的包（在这个例子中是`com.itheima`）及其子包中自动查找带有Spring组件注解的类（比如`@Component`, `@Service`, `@Repository`, `@Controller`）并注册为Spring容器中的Bean

使用**包扫描器**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           https://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           https://www.springframework.org/schema/context/spring-context.xsd">

    <context:component-scan base-package="com.itheima" />

</beans>

```

## 3注解方式+JAVA配置类

配置类扫描取代了xml中的扫描

```java
@Configuration
@ComponentScan("com.itheima")
public class SpringConfig{
  @Bean
  public DruidDataSource getDataSource(){
    DruidDataSource ds = new DruidDataSource();
    return ds;//将这个方法的返回值作为一个Bean交由Spring管理
    //每个这样的方法都会返回一个对象，该对象会被注册为一个Bean。
  }
}
```

获取Bean,注意不同于上面的ClassPath而是使用Annotation

```java
ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
String[] names = ctx.getBeanDefinitionNames();
```

## 4Import方式直接导入

导入的是**全路径名**。

```java
@Configuration
@Import(AnotherConfig.class)
public class AppConfig {
    // ...
}

```

## 5使用上下文对象在容器初始化后注入Bean

<img src="../Pic/image-20240401192008417.png" alt="image-20240401192008417" style="zoom:50%;" />

## 6优化Import增加选择条件

<img src="../Pic/image-20240401192715978.png" alt="image-20240401192715978" style="zoom:50%;" />

使用ImportSelector接口

```java
public class MyImportSelector implements ImportSelector{
  public String[] selectImports(AnnotationMetadata metadata){//注意参数是元数据
    boolean flag = metadata.hasAnnotation("org.springframework.context.annotation.Import");
    if(flag){
      return new String[]{"com.itheima.domain.Dog"};
      }
    }
  return new String[]{"com.itheima.domain.Dog"};
  }
}
```

## 7更加高级registry

BeanDefinitionRegistry深入到Bean的定义过程中。

<img src="../Pic/image-20240401193438674.png" alt="image-20240401193438674" style="zoom:50%;" />

## 8注册完后进行顺序裁定

<img src="../Pic/image-20240401194448080.png" alt="image-20240401194448080" style="zoom:50%;" />

# Bean的加载控制

## 编程控制

后四种加载Bean的方式都可以利用编程的形式进行控制。

## 注解控制

可以按照类型、Bean名称进行匹配。

<img src="../Pic/image-20240401203540389.png" alt="image-20240401203540389" style="zoom:50%;" />

# 各种注解的解释

## @Controller

管理Web路由，作为控制层来处理Web发来的请求——接受请求，调用业务逻辑，更新模型，返回视图。

### @RequestMapping

将控制器中的方法映射到HTTP请求。通过指定URL模式、HTTP方法等参数，可以精细控制哪些请求会被哪些方法处理

- **类级别**：在类级别使用`@RequestMapping`时，它提供了一个基础的请求路径。此后，类中所有的方法映射都将在此基础路径之上进行。
- **方法级别**：在方法级别使用时，`@RequestMapping`指定该方法处理的具体请求路径及方法。

参数：

- `value`：指定请求的URL。
- `method`：指定请求使用的HTTP方法（如`GET`, `POST`等）。
- `consumes`：指定处理请求的提交内容类型（Content-Type），例如`application/json`。
- `produces`：指定返回的内容类型，例如`application/json`。

```java
@Controller
@RequestMapping("/users")//处理/users/路径下的Web请求
public class UserController {

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "userProfile";  // 返回视图名称
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("userId") String userId, @ModelAttribute("user") User user) {
        userService.updateUser(userId, user);
        return "redirect:/users/" + userId;
    }
}
```

### @RestController

适用于Restful服务（API、AJAX、微服务）；不像上面Controller可以返回视图，RestController不仅将类标记为一个控制器，同时表明该控制器的**所有方法都默认响应的是数据而非视图**。

- 使用`@RestController`标记的类中的所有方法都会自动使用`@ResponseBody`。这意味着方法的返回值会直接作为HTTP响应的主体返回，而不是解析为视图名称。这对于开发REST API非常有用，因为REST API通常返回JSON或XML格式的数据。
- 不需要在每个方法上重复`@ResponseBody`注解，`@RestController`使得代码更加简洁。

## @Autowired

对类成员变量、方法、构造函数进行标注，完成自动装配，消除了set，get方法。

## @PathVariable

将URL中的动态部分提取出来，可以作为参数传递给方法。（见上面的示例代码）

如果方法参数名和路径变量名不一致，你可以在`@PathVariable`注解中指定路径变量的名称：

```java
@GetMapping("/{id}")
public User getUserById(@PathVariable("id") String userId) {
    return userService.getUserById(userId);
}
```