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