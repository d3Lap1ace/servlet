<!DOCTYPE html>
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
                    <td></td>
                    <td></td>
                    <td></td>
                    <td class="buttonContainer">
                        <button class="btn1" onclick="delSchedule(${schedule.sid})">删除</button>
                        <button class="btn1" onclick="editSchedule(${schedule.sid})">保存修改</button>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${sysSchedules.size()==0}">
            <tr class="ltr" align="center">
                <td colspan="4"><font color="red">没有学习计划</font> </td>
            </tr>
        </c:if>
    </tbody>
    <tfoot>
        <tr class="ltr buttonContainer" >
            <td colspan="4">
                <c:forEach begin="1" end="${totalPage}" var="page">
                    <a href="/schedule/show?page=${page}" style="border: 1px solid blue;padding: 2px;margin: 4px;text-decoration: none">${page}</a>
                </c:forEach>
            </td>
        </tr>
        <tr class="ltr buttonContainer">
            <td colspan="4">
                <button class="btn1" onclick="addSchedule()">新增日程</button>
            </td>
        </tr>
    </tfoot>
</table>
</body>
<script>
    function addSchedule(){
        var title = prompt("输入学习计划");
        location.href="/schedule/add?title="+title;
    }
    function delSchedule(sid){
        if(confirm("是否要删除sid="+sid+"学习计划?")){
            location.href="/schedule/del?sid="+sid;
        }
    }
    function editSchedule(sid){
        location.href="/schedule/detail?sid="+sid;
    }
</script>
</html>