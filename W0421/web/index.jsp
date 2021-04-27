<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 2021/4/21
  Time: 4:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <form action="StudentServlet" method="post">
      编号：<input type="text" name="no">
      姓名：<input type="text" name="name">
      性别：<input type="text" name="sex">
      年龄：<input type="text" name="age">
      <input type="submit" value="提交">
    </form>
  </body>
</html>
