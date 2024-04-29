<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"   %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

      <%
        //直接可以写java代码
          //jsp所有代码: servlet -> service(request,response) -> 直接使用的对象叫jsp内置对象
          //内置对象一共有9个: request response pageContext session page(this) application(servletContext) config(servletContext) out  隐藏: exception
         String name = "ergouzi";
         request.setAttribute("key",name);
         List<String> names = new ArrayList<>();
         names.add("小井老师");
         names.add("小泽老师");
         names.add("小利老师");
         names.add("小崩老师");
         request.setAttribute("names",names);
      %>

      <!--
         <  %=变量和值  %> -> 值输出到页面! 实现动态页面技术!
            out.print(request.getAttribute("key"))
      -->
      <button>  <%=request.getAttribute("key") %>  </button>
      <hr>
      <button>  <% out.print(request.getAttribute("key")); %>  </button>


      <table border="1px" bordercolor="red">
           <thead>
                <tr>
                    <th>编码</th>
                    <th>姓名</th>
                </tr>
           </thead>
           <tbody>

           <%
               for (int index = 0 ; index<names.size() ; index++){
           %>
                <tr>
                    <td><%=index+1 %> </td>
                    <td><%=names.get(index)%></td>
                </tr>
           <%
               }
           %>

           </tbody>
      </table>

  </body>
</html>
