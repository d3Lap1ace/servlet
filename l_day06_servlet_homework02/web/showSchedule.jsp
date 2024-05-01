<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="gbk">
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
<h3 class="ht">您的日程如下</h3>

<table class="tab" cellspacing="0px">
    <thead>
        <tr class="ltr">
            <th>编号</th>
            <th>内容</th>
            <th>进度</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody id="tb">
    <c:if test="${sysSchedules.size()>0}">
        <c:forEach items="${sysSchedules}" var="schedule">
            <tr class="ltr">
                <td>${schedule.sid}</td>
                <td>${schedule.title}</td>
                <td>${schedule.completed == 0?'未完成':'已完成'}</td>
                <td class="buttonContainer">
                    <button class="btn1">删除</button>
                    <button class="btn1">保存修改</button>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${sysScheudles.size()==0}">
        <tr class = "ltr" align="center">
            <td colspan="4"><font color="red">没有学习计划!不学习我们怎么活?</font> </td>
        </tr>
    </c:if>
    </tbody>

    <tr class="ltr buttonContainer" >
        <td colspan="4">
            <button class="btn1">新增日程</button>
        </td>

    </tr>
</table>

</body>
</html>