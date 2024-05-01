<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>

        .ht{
            text-align: center;
            color: cadetblue;
            font-family: 幼圆;
        }
        .tab{
            width: 80%;
            border: 5px solid cadetblue;
            margin: 0px auto;
            border-radius: 5px;
            font-family: 幼圆;
        }
        .ltr td{
            border: 1px solid  powderblue;

        }
        .ipt{
            border: 0px;
            width: 50%;

        }
        .btn1{
            border: 2px solid powderblue;
            border-radius: 4px;
            width:100px;
            background-color: antiquewhite;

        }
        #usernameMsg , #userPwdMsg {
            color: gold;
        }

        .buttonContainer{
            text-align: center;
        }
    </style>


</head>
<body>
<h1 class="ht">欢迎使用日程管理系统</h1>
<h3 class="ht">日程修改</h3>
<form method="post" action="/schedule/schedule/update">
    <input type="hidden" name="sid" value="${schedule.sid}">
    <table class="tab" cellspacing="0px">
        <tr class="ltr">
            <th>内容</th>
            <th>进度</th>
        </tr>
                <tr class="ltr">
                    <td><input type="text" name="title" value="${schedule.title}"> </td>
                    <td>
                        <input type="radio" name="completed" value="1"  checked="${schedule.completed==1?'checked':''}"> 已完成
                        <input type="radio" name="completed" value="0"  checked="${schedule.completed==0?'checked':''}"> 未完成
                    </td>
                    <td class="buttonContainer">
                        <button class="btn1">修改</button>
                    </td>
                </tr>
    </table>
</form>
</body>
</html>