<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教师界面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<script language="javascript">
    function delcfm()
    {
        if (!confirm("确定删除？？"))
        {
            window.event.returnValue = false;
        }
    }
</script>

<body>
<div class="container" style="width:1920px;height:120px;margin-top:0;background-image:linear-gradient(to bottom,#595959,#E0EEEE);background-size:100%;background-repeat:no-repeat">
    <br>
    <h1>数据结构课程学习网站</h1>
    <h6>教师端</h6>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="TeachersHome.jsp">我教的班级</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown">
                        欢迎您！${sessionScope.user.name}
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="lyx_Login_check_Servlet">注销</a></li>
                        <li><a href="TeacherModPwd.jsp">修改密码</a></li>
                        <li><a href="TeacherMod.jsp">修改信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="panel panel-info col-md-offset-1 col-md-10">
    <div class="panel-heading">
        <h3 align="center" class="panel-title">我的班级表</h3>
    </div>
    <div class="panel-body">
        <c:forEach var="cls" items="${sessionScope.ClsList}" varStatus="status" >
            <div class="panel panel-success col-md-6">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <a href="class_of_teacher_homeServlet.do?classId=${cls.id}">班级名称：${cls.name}</a>
                    </h3>
                </div>
                <div class="panel-body">
                    授课教师：${cls.teacher}<br>
                    班级人数：${cls.studentSum}<br>
                    开课时间：${cls.startDate}至${cls.endDate}<br>
                    <a href="TeacherUpdateClass.jsp?classId=${cls.id}&name=${cls.name}&startDate=${cls.startDate}&endDate=${cls.endDate}" >修改</a>&nbsp;&nbsp;
                    <a  onclick='delcfm()' href="class_of_delete_classServlet.do?classId=${cls.id}" onMouseOver = "this.style.color = 'red'" onMouseOut = "this.style.color = ''  "><blink>删除</blink></a>
                </div>
            </div>
        </c:forEach>

        <div class="panel panel-success col-md-6">
            <div class="panel-heading">
                <h3 class="panel-title">.</h3>
            </div>
            <div class="panel-body">
                <a href="TeacherAddClass.jsp"><h1 align="center" >+</h1> </a><h4></h4>
            </div>
        </div>

    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
