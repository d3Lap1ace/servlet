<%--
  Created by IntelliJ IDEA.
  User: d3lap1ace
  Date: 30/4/2024
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <button onclick="sendAjax()">发起请求</button>
    <button onclick="sendAjaxQuery()">使用GET方式传递query参数</button>
    <button onclick="sendAjaxPost()">使用POST方式传递query参数</button>
    <button onclick="sendAjaxPostJSON()">使用post方式传递json参数</button>
    <script>
      function sendAjax() {
        // 创建请求对象XmlHttpRequest
        var ajax = new XMLHttpRequest();
        // 设置请求监听,是否请求完毕,完毕获取相应数据
        ajax.onreadystatechange = function () {
          if (ajax.readyState == 4 && ajax.status == 200) {
          }
          var respText = ajax.responseText;
          console.log(respText);
        }

        // 设置亲贵参数open
        ajax.open("GET", "/controller/ajax")
        // 开始请求
        ajax.send();
      }

      function sendAjaxQuery() {
        var ajax1 = new XMLHttpRequest();
        //监听
        ajax1.onreadystatechange = function (){
          if(ajax1.readyState == 4 && ajax1.status == 200){
            console.log(ajax1.responseText);
          }
        }
        // 设置请求参数
        ajax1.open("GET","/controller/ajax1?name=root&age=11");
        // 发送
        ajax1.send();
      }

      function sendAjaxPost() {
        var ajax2 = new XMLHttpRequest();
        ajax2.onreadystatechange = function (){
          if(ajax2.readyState == 4 && ajax2.status == 200){
            console.log(ajax2.responseText);
          }
        }
        ajax2.open("POST","/controller/ajax2");
        //发起请求
        ajax2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        ajax2.send("name = root&age = 11");
      }
      function sendAjaxPostJSON(){
        var ajax3 = new XMLHttpRequest();

        ajax3.onreadystatechange =function (){
          if(ajax3.readyState == 4 && ajax3.status == 200){
            console.log(ajax3.responseText);
          }
        }
        ajax3.open("POST","/controller/ajax3");
        ajax3.setRequestHeader("Content-type","application/json");
        var student ={name:"ergouzi",age:18}
        ajax3.send(JSON.stringify(student));
      }
    </script>

  </body>
</html>
