<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.javaEE.servlet.pojo.SysUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        List<SysUser> list = new ArrayList<SysUser>();
        SysUser sysUser = new SysUser(1,"root","123456");
        SysUser sysUser1 = new SysUser(2,"root","123456");
        SysUser sysUser2 = new SysUser(3,"root","123456");
        SysUser sysUser3 = new SysUser(4,"root","123456");
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



    <c:forEach begin="1" end="100" step="1" var="item">
        <c:if test="${item%2==1}">
            <p><font color="red">${item}</font></p>
        </c:if>
        <c:if test="${item%2==0}">
            <p><font color="green">${item}</font></p>
        </c:if>
    </c:forEach>

</body>
</html>
