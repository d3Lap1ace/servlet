<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.javaEE.servlet.pojo.SysUser" %><%--
  Created by IntelliJ IDEA.
  User: d3lap1ace
  Date: 29/4/2024
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--   输出 1 - 100 的值  1
                         2
                         3
             for(int item = 1 ; item <= 100 ; i++){

             }

             奇数 -> 红色
             偶数 -> 绿色
--%>

  <%
    ArrayList<SysUser> list = new ArrayList<>();
    SysUser  sysUser = new SysUser(1,"root","123456");
    SysUser  sysUser1 = new SysUser(2,"root","123456");
    SysUser  sysUser2 = new SysUser(3,"root","123456");
    SysUser  sysUser3 = new SysUser(4,"root","123456");
    list.add(sysUser);
    list.add(sysUser1);
    list.add(sysUser2);
    list.add(sysUser3);
    request.setAttribute("list",list);

  %>


  <table border="1px" bordercolor="red">
    <tr>
      <th>id</th>
      <th>username</th>
      <th>password</th>
    </tr>
    <c:forEach items="${list}" var="user">
      <tr>
        <td>${user.uid}</td>
        <td>${user.username}</td>
        <td>${user.userPwd}</td>
      </tr>
    </c:forEach>

    <c:forEach begin="0" end="${list.size()-1}" var="i" step="1">
      <tr>
        <td>${list.get(i).uid}</td>
        <td>${list.get(i).username}</td>
        <td>${list.get(i).userPwd}</td>
      </tr>
    </c:forEach>
  </table>



  <c:forEach begin="1" end="100" var="i" step="2">
    <c:if test="${i%2==1}">
      <p><font color="red">${i}</font> </p>
    </c:if>
    <c:if test="${i%2==0}">
      <p><font color="black">${i}</font> </p>
    </c:if>
  </c:forEach>
</body>
</html>
