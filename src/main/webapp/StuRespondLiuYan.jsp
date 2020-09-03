<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/5/3
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
<jsp:include page="StudentNavigtionBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">
        <form action="StuRespondLiuYan.do" method="post">
            <div class="col-sm-8">
                <br><br>
                <br><br>
                <div class="form-group">
                    <label for="title" class="col-sm-1 control-label">标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="title" name="title" placeholder="请输入标题">
                    </div>
                </div>
                <br><br>
                <div class="form-group">
                    <label for="content" class="col-sm-1 control-label">内容</label>
                    <div class="col-sm-10">
                                <textarea class="form-control" rows="8" id="content" name="content" placeholder="请输入内容">
                                </textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <br>
                        <input type="checkbox" name="anonymity">匿名
                    </div>
                </div>
                <br><br>
                <br><br><br>
                <div class="form-group">
                    <div class="col-sm-10">
                        <br><br><br>
                        <button type="submit" class="btn btn-warning" style="width:80px">提交</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
