<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container" style="width:1920px;height:130px;margin-top:0;background-image:linear-gradient(to bottom,#595959,#FFDAB9);background-size:100%;background-repeat:no-repeat">
    <br>
    <h1>数据结构在线学习网站</h1>
    <h6>学生端</h6>
    <a href="StudentsHome.jsp"><返回></a><br>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="StudentHomePage.jsp">主页</a></li>
                <li><a >签到</a></li>
                <li><a >通知</a></li>
                <li><a href="#">作业</a></li>
                <li><a href="StudentListFileServlet.do">资料</a></li>
                <li><a href="#">考试</a></li>
                <li><a href="StuCourseHome.jsp">讨论</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown">
                         欢迎您！${sessionScope.user.name}
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="lyx_Login_check_Servlet">注销</a></li>
                        <li><a href="StudentModPwd.jsp">修改密码</a></li>
                        <li><a href="StudentMod.jsp">修改信息</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>



<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
