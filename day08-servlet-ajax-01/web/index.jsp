<%--
  Created by IntelliJ IDEA.
  User: Jackiechan
  Date: 2024/4/30
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
      <button onclick="sendAjax()">发起请求</button>
      <button onclick="sendAjaxQuery()">使用GET方式传递参数</button>
      <button onclick="sendAjaxPost()">使用Post方式传递query参数</button>
      <button onclick="sendAjaxPostJSON()">使用Post方式传递json参数</button>
      <script>

        function sendAjax(){
          //1.创建请求对象XmlHttpRequest
          var ajax = new XMLHttpRequest();
          //2.设置请求监听,是否请求完毕,完毕获取响应数据
          ajax.onreadystatechange = function () {
              //里面
              if (ajax.readyState == 4 && ajax.status == 200) {
                  var respText = ajax.responseText; //json
                  console.log(respText);
              }
          }
          //3.设置请求参数open  method url true
          ajax.open("GET","/controller/ajax");
          //4.开始请求
          ajax.send();
        }


        /**
         *
         * ajax请求的参数传递问题: query (key=value&key=value)  json ({key:value,key:value})
         *    get:  query
         *          open(method,url?key=value)
         *    post: query json
         *          open(method,url?key=value)
         *          send(参数)
         *               key=value  Content-type","application/x-www-form-urlencoded
         *               json字符串 Content-type","application/json
         */

        function sendAjaxQuery(){
            //1.创建请求对象
            var ajax1 = new XMLHttpRequest();
            //2.设置监听状态
            ajax1.onreadystatechange = function (){
                if (ajax1.readyState == 4 && ajax1.status == 200){
                    console.log(ajax1.responseText);
                }
            }
            //3.设置请求参数
            ajax1.open("GET","/controller/ajax1?name=root&age=11");
            //4.发起请求
            ajax1.send();
        }


        function sendAjaxPost(){
            //1.创建请求对象
            var ajax2 = new XMLHttpRequest();
            //2.设置监听状态
            ajax2.onreadystatechange = function (){
                if (ajax2.readyState == 4 && ajax2.status == 200){
                    console.log(ajax2.responseText);
                }
            }
            //3.设置请求参数
            ajax2.open("POST","/controller/ajax2");
            //4.发起请求
            ajax2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            //send(请求体字符串  name=root&age=11 || json)
            ajax2.send("name=root&age=11");
        }


        function sendAjaxPostJSON(){
            //1.创建请求对象
            var ajax3 = new XMLHttpRequest();
            //2.设置监听状态
            ajax3.onreadystatechange = function (){
                if (ajax3.readyState == 4 && ajax3.status == 200){
                    console.log(ajax3.responseText);
                }
            }
            //3.设置请求参数
            ajax3.open("POST","/controller/ajax3");
            //4.发起请求
            ajax3.setRequestHeader("Content-type","application/json");
            //send(请求体字符串  name=root&age=11 || json)
            var student = {name:"ergouzi",age:18}
            ajax3.send(JSON.stringify(student));
        }

      </script>
  </body>
</html>
