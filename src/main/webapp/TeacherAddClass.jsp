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
        if (!confirm("确定增加？？"))
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
                <li class="active"><a href="class_of_teacherServlet.do">返回</a></li>
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
        <h3 align="center" class="panel-title">请填写新增课程信息</h3>
    </div>
    <div class="panel-body">
        <ul class="nav nav-pills nav-stacked">
            <div id="input">
                <form action="class_of_add_classServlet.do" class="form-horizontal" role="form" method="post">

                    <div class="form-group">
                        <label for="class_name" class="col-sm-4 control-label">课程名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="class_name" name="name" placeholder="请设定课程名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="start_date" class="col-sm-4 control-label">开课日期</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="start_date" name="startDate" placeholder="请设定开课日期(类型为年-月-日)">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="end_date" class="col-sm-4 control-label">结课日期</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" id="end_date" name="endDate" placeholder="请设定结课日期(类型为年-月-日)">
                        </div>
                    </div>
                    <div id="button" class="form-group">
                        <div align="center"  class="col-sm-12">
                            <button onclick='delcfm()'type="submit" class="btn btn-default">确定</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>
                    </div>

                </form>
            </div>
        </ul>
    </div>

</div>

<c:if test="${addisOK ==1 }">

     <div   class="alert alert-success alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">增加课程信息成功！请返回查看</span>
     </div>
</c:if>
<c:if test="${addisOK ==0}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">课程、时间格式错误或为空！</span>
     </div>

</c:if>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
