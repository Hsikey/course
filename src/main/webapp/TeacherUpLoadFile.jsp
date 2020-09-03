
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>上传界面</title>
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<script language="javascript">
    function delcfm()
    {
        if (!confirm("确定上传？？"))
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
                <li class="active"><a href="ListFileServlet.do">返回</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="panel panel-info col-md-offset-1 col-md-10">
    <div class="panel-heading">
        <h3 align="center" class="panel-title">请选择需要上传的文件</h3>
    </div>
    <div class="panel-body">
        <ul class="nav nav-pills nav-stacked">
            <div id="input">
                <form action="UploadHandleServlet.do" enctype="multipart/form-data" class="form-horizontal" role="form" method="post" >
                    <div class="form-group" >
                        <div class="panel panel-success col-md-12">
                            <div align="center" class="panel-body">
                                <input type="file" name="file1">
                            </div>
                        </div>
                        <div class="panel panel-success col-md-12">
                            <div align="center" class="panel-body">
                                <input type="file" name="file2">
                            </div>
                        </div>
                        <div class="panel panel-success col-md-12">
                            <div align="center" class="panel-body">
                                <input type="file" name="file3">
                            </div>
                        </div>
                    </div>
                    <div id="button" class="form-group" class="col-sm-12">
                        <div align="center">
                            <button onclick='delcfm()' type="submit" class="btn btn-default">确定上传</button>
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
      	<span style="font-size:14px;text-align:center;display:block;">${message}</span>
     </div>
</c:if>
<c:if test="${addisOK ==0}">
     <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
   	   <button type="button" class="close" data-dismiss="alert"
   		   	aria-hidden="true">
   		&times;
   	   </button>
      	<span style="font-size:14px;text-align:center;display:block;">${message}</span>
     </div>

</c:if>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
