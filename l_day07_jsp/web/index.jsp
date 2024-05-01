<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: d3lap1ace
  Date: 29/4/2024
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    String name = "ergouzi";
    request.setAttribute("key",name);
    ArrayList<String> names = new ArrayList<>();
    names.add("ilyas");
    names.add("niklas");
    names.add("eva");
    names.add("jone");
    request.setAttribute("names",names);
  %>
  <button>
    <%=request.getAttribute("key")%>
  </button>
  <hr>
  <table border="1px" bgcolor="red">
    <thead>
      <tr>
        <th>编码</th>
        <th>姓名</th>
      </tr>
    </thead>
    <tbody>
      <% for(int index = 0; index <names.size();++index){%>
        <tr>
          <td><%=index+1%></td>
          <td><%=names.get(index)%></td>
        </tr>
      <%}%>

    </tbody>
  </table>

</body>
</html>
