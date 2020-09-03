<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
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
<div class="container" style="width:1920px;height:120px;margin-top:0;background-image:linear-gradient(to bottom,#595959,#FFEC8B);background-size:100%;background-repeat:no-repeat">
    <br>
    <h1>数据结构课程学习网站</h1>
    <h6>管理端</h6>
</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="admin_search_all_teacherServlet.do">返回</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle glyphicon glyphicon-user" data-toggle="dropdown">
                        欢迎您！${sessionScope.user.account}
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
        <h3 align="center" class="panel-title">请填写新增教师信息</h3>
    </div>
    <div class="panel-body">
        <ul class="nav nav-pills nav-stacked">
            <div id="input">
                <form action="admin_add_teacherServlet.do" class="form-horizontal" role="form" method="post">
                    <div class="form-group">
                        <label  class="col-sm-4 control-label">教师工号</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"  name="taccount" placeholder="请设定教师工号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-4 control-label">教师名称</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"  name="name" placeholder="请输入教师名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-4 control-label">教师密码</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"  name="password" placeholder="请设定教师密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">教师性别</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"  name="sex" placeholder="请设定教师性别">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">教师电话</label>
                        <div class="col-sm-5">
                            <input type="text" class="form-control"  name="phone" placeholder="请输入教师电话">
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
      	<span style="font-size:14px;text-align:center;display:block;">增加教师信息成功！请返回查看</span>
     </div>
</c:if>
<c:if test="${addisOK ==0}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">增加教师信息错误！教师工号或密码不能重复或为空！</span>
     </div>

</c:if>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
