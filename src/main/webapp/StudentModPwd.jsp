<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<script language="javascript">
	function delcfm()
	{
		if (!confirm("确定修改？？"))
		{
			window.event.returnValue = false;
		}
	}
</script>
<c:if test="${sessionScope.modpasswordisOk ==1 }">
        <%
          response.sendRedirect("login.jsp");
        %>
</c:if>
<c:if test="${sessionScope.modpasswordisOk ==2 }">
        <script type="text/javascript" language="javascript">
            alert("修改失败！");
        </script>
</c:if>
<c:if test="${sessionScope.modpasswordisOk ==3 }">
        <script type="text/javascript" language="javascript">
            alert("修改失败，密码错误！");
        </script>
</c:if>
<c:set var="modpasswordisOk" value="${null}" scope="session"/>

<body>
<div class="container" style="width:1920px;height:120px;margin-top:0;background-image:linear-gradient(to bottom,#595959,#FFDAB9);background-size:100%;background-repeat:no-repeat">
    <br>
    <h1>数据结构在线学习网站</h1>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="StudentsHome.jsp">我的班级</a></li>
                <li><a href="class_sign_upServlet.do">班级报名</a></li>
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

<div   class="alert alert-danger alert-dismissable col-md-offset-3 col-md-6">
 	<button type="button" class="close" data-dismiss="alert"
 			aria-hidden="true">
 		&times;
 	</button>
 	<span style="font-size:14px;text-align:center;display:block;">如非本人，请谨慎操作！</span>

 </div>
<br><br><br>
 <div style="background:grey" class="container col-md-offset-3 col-md-6" >
 	<div class="row clearfix">
 		<div class="col-md-24 column">
 			<br><br>
 			<h2 class="text-center text-black ">
 				密码修改
 			</h2><br>
 			<form action="StudentModPwd" method="post" class="form-horizontal " role="form">

 				<div class="form-group "  >
 					<label class="col-sm-4 control-label" for="inputEmail3">旧密码:</label>
 					<div class="col-sm-4 ">
 						<input class="form-control" placeholder="旧密码" name="oldpassword" type="password" />
 					</div>
 				</div>

 				<div class="form-group "  >
                      <label class="col-sm-4 control-label" for="inputEmail3">新密码:</label>
                 	 <div class="col-sm-4 ">
                 		<input class="form-control" placeholder="新密码" name="newpassword" type="password" />
                 	 </div>
                 </div>

                 <div class="form-group "  >
                 	 <label class="col-sm-4 control-label" for="inputEmail3">确认密码</label>
                 	 <div class="col-sm-4 ">
                 		<input class="form-control" placeholder="新密码" name="newpassword1" type="password" />
                 	 </div>
                 </div>

                 <div class="form-group">
 					<div class="col-sm-offset-4 col-sm-4">
 						 <button onclick="delcfm()" class="btn btn-danger btn-lg btn-block" type="submit">确定</button>
 					</div>
 				</div>
 			</form>
 		</div>
 	</div>
 </div>

</body>
</html>
