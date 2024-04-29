<%--
  Created by IntelliJ IDEA.
  User: d3lap1ace
  Date: 29/4/2024
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    request.setAttribute("key","data");
    session.setAttribute("key","session");
  %>
<p> <%= request.getAttribute("key")%></p>
<p> <%out.print(request.getAttribute("key"));%></p>
  el表达式怎么输出: ${key} -> 1. 获取共享域指定key的数据输出!
  2. 从小到大范围共享域获取,有了就停止!   request session application(servletContext)
  3. 指定共享域  requestScope sessionScope applicationScope  . key

<hr>
<p>${key}</p>
<p>${sessionScope.key}</p>

</body>
</html>
