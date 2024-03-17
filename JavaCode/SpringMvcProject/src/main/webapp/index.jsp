<%--
  Created by IntelliJ IDEA.
  User: lutao
  Date: 2024/3/17
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br><br>
<a href="${pageContext.request.contextPath}/demo.action">访问服务器</a>
<form></form><br><br><br>
<h2>1.单个数据提交</h2>
    <form action="${pageContext.request.contextPath} /one.action">
        姓名:<input name="myname"><br>
        年龄:<input name="age"><br>
        <input type="submit" value="提交">
    </form>
<h2>3.动态占位符提交</h2>
    <a href="${pageContext.request.contextPath}/three/张三/22.action">动态提交</a>
</body>
</html>
