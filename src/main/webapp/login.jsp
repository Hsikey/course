<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=IS0-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录界面</title>

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .row{
            text-align:center;
            margin-top: 120px;
        }
        .form-horizontal{
            background: #fff;
            padding: 100px 100px 50px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 1px solid #f0f0f0;
            margin-bottom: 30px;
        }

        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            width: 380px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
</head>


<body style=" background: gray no-repeat center center fixed; background-size: 100%;">
<c:if test="${!empty requestScope.isOK}">
    <c:if test="${requestScope.isOK eq '1' }">
        <script type="text/javascript" language="javascript">
            alert("账号或密码错误！");
        </script>
    </c:if>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
<form class="form-horizontal" style="padding: 30px 100px 30px" action="lyx_Login_check_Servlet" method="post">
    <span class="heading">用户登录</span>
    <div class="form-group">
        <input type="text" class="form-control" name="account" placeholder="用 户 名">
    </div><br/>
    <div class="form-group help">
        <input type="password" class="form-control" name="password" placeholder="密　码">
    </div><br/>
    <label class="radio-inline">
        <input type="radio" name="role" value="student" checked> 学生
    </label>
    <label class="radio-inline">
        <input type="radio" name="role" value="teacher"> 教师
    </label>
    <label class="radio-inline">
        <input type="radio" name="role" value="administrator"> 管理员
    </label>
    <br/>
    <br/><br/>
    <button type="submit" class="btn btn-warning btn-lg btn-block" >登录</button>
    <br/>
    <br/>
    <br/>
    <a class="text-right" href="register.jsp">未注册？点这里注册</a>
</form>
        </div>
    </div>
</div>

<c:if test="${loginisOK ==0}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">账号或密码错误！请重新输入</span>
     </div>
</c:if>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
