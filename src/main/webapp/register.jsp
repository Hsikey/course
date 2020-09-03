<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册界面</title>
    <!-- 引入 Bootstrap -->
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
            text-align: left;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
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
<body style=" background: #262626 no-repeat center center fixed; background-size: 100%;">


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="js/bootstrap.min.js"></script>

<div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6">
<form class="form-horizontal" style="padding: 30px 40px 30px" action="lyx_Regist_Servlet" method="post">
    <fieldset>
        <legend>   用户注册</legend>
    </fieldset>
    <div class="form-group">
        <label for="inputusername" class="col-sm-3 control-label">账号:</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="account" id="inputusername" placeholder="8位字母、数字（区分大小写）">
        </div>
    </div>
    <div class="form-group">
        <label for="inputname" class="col-sm-3 control-label">姓名:</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="name" id="inputname" placeholder="姓   名">
        </div>
    </div>
    <div class="form-group">
        <label for="inputpassword" class="col-sm-3 control-label">密码:</label>
        <div class="col-sm-8">
            <input type="password" class="form-control" name="password" id="inputpassword" placeholder="6位字母、数字（区分大小写）">
        </div>
    </div>

    <div class="form-group">
        <label for="inputtel" class="col-sm-3 control-label">电话:</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="phonenumber" id="inputtel" placeholder="电   话">
        </div>
    </div>
    <div class="form-group">
        <label for="inputa" class="col-sm-3 control-label">性别:</label>
        <div class="col-sm-8">
            <input type="text" class="form-control" name="sex" id="inputa" placeholder="性别">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-3 col-sm-4">
            <button type="submit" class="btn btn-warning" style="width:310px" id="regist">立即注册</button>
        </div>
    </div>
</form>
<a class="text-right" href="login.jsp">已有账号？点这里登录</a>
        </div>
    </div>
</div>
<br >

<c:if test="${registerisOK ==0 }">
    <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
  	   <button type="button" class="close" data-dismiss="alert"
  		   	aria-hidden="true">
  		   &times;
  	  </button>
     	<span style="font-size:14px;text-align:center;display:block;">账号已存在！请重置账号或直接登录！</span>
    </div>

</c:if>
<c:if test="${registerisOK ==1 }">

     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">注册成功！</span>
     </div>
</c:if>
<c:if test="${registerisOK ==2}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">注册失败,未知错误！</span>
     </div>

</c:if>
<c:if test="${registerisOK ==3}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">注册失败,请填写密码</span>
     </div>
</c:if>

</body>
</html>
