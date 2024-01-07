# Servlet

## 动静态资源：

无需程序运行时需要代码运行才能生成的资源，**在程序运行之前就写好的**如html css js img；反之则为动态资源，**程序运行前无法确定的**，如Servlet

- 动态资源在请求和响应时每次响应的都是Java代码即时运行后产生的结果。
- **Servlet技术标准可以作为Java代码接受用户的请求。**
- 必须在Web项目中开发在Tomcat容器中进行。

## Servlet运行流程：

- Tomcat接收到请求报文时，将其转换为**HttpServeletRequest对象**，包含请求的所有信息。
- 同时创建Response对象，未来会转换成响应报文。
- 根据请求中的资源路径找到对应的servlet，将其servlet实例化，调用其中的service方法。**将上面两个对象传入方法中**
- <img src="../Pic/image-20240106232541939.png" alt="image-20240106232541939" style="zoom:50%;" />引用传递

Servlet作用主要是承前启后，<img src="../Pic/image-20240106233529348.png" alt="image-20240106233529348" style="zoom:50%;" />

## Servlet开发流程

### 创建Javaweb项目，将Tomcat添加为项目依赖

<img src="../Pic/image-20240107163707401.png" alt="image-20240107163707401" style="zoom:50%;" />

### 重写service方法

```java
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
```

### 在service方法中，定义业务代码

```java
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从客户端传来的Request对象中获得信息
        String username = request.getParameter("username");//根据参数名获取参数值，可能在url或者请求体中
        //处理业务代码
        String info = "YES";
        if ("atguigu".equals(username)){
            info = "NO";
        }
        //将响应的数据放入Response对象中
        PrintWriter writer = response.getWriter();//该方法返回的向响应体中打印字符的打印流
        writer.write(info);
    }
```



### 在web.xml中配置Servlet请求映射路径

```html
    <!--
        1配置servlet类，并起一个别名
        class是全路径，进行实例化，根据全路径反射创建对象调用Service方法
        name是用于关联请求的映射路径
        2使用mapping映射别名和路径
    -->
    <servlet>
        <servlet-name>userServlet</servlet-name>
        <servlet-class>com.ltx.servelet.UserServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>userServlet</servlet-name>
        <url-pattern>/userServlet</url-pattern>
    </servlet-mapping>
```

- 注意pattern里的路径对应的是`index.html`中的action
- 运行时建议以Debug模式运行，并且可能存在8080端口被占用的情况，需要查看进程并kill掉
- `sudo lsof -i :8080 sudo kill -9 PID`

### 注解方式配置Servlet映射路径

在java工程的类之前`@WebServlet("/s1")`，**配置上下文路径**即可。

## 额外问题

### Jar

继承的servlet并不是IDEA所内置的，我们在**添加Tomcat依赖**时会自动导入对应api-jar包。不用自己创建lib导入响应jar包（Tomcat中没有的jar包才需要自己导入）

### Content-Type响应头

决定了返回的数据类型：`response.setHeader("Content-Type","text/html");`

### Pattern映射路径作用

- 通过localhost定位服务器，通过8080定位tomcat，（tomcat会向外暴露webapps）

- 会由web.xml中的pattern字段（也是url后面的字段）找到servlet-name，定位到对应的servlet-class通过反射获得字节码，最后获取servlet对象。
- **一个name可以对应多个pattern,不同的servlet不能拥有相同的pattern；但可以对应多个mapping标签。**

#### 精确匹配

`<url-pattern>/s1</url-pattern>`

#### 模糊匹配

/意味着匹配全部, 不包含jsp文件；/*匹配全部，包含jsp文件。

*在哪里哪里就是模糊的。

## 生命周期：

作为开发者只需要在service方法中进行编写java代码，其对象的创建和销毁都由Tomcat完成。

### 四个过程：

- 实例化（构造器）1
- 初始化 init 1
- 接受处理请求 service 多次
- 销毁对象 destory 1

**Servlet是单例的**，成员变量在*多个线程栈中共享*，不支持在service方法中修改成员变量，否则引发**线程安全问题。**

实例化顺序，在注解方式的参数配置`loadOnStartup = xx`

**静态资源由defaultServlet进行加载。**