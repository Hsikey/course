<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/5/2
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>回复评论</title>
</head>
<body>
<jsp:include page="StudentNavigtionBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">
<form action="Comment.do" method="post">
    <div class="col-sm-8">
        <br><br>
        <br><br>
        <div class="form-group">
            <label for="d_content" class="col-sm-2 control-label" style="padding-left:70px">回复内容</label>
            <div class="col-sm-10">
             <textarea class="form-control" rows="8" id="d_content" name="d_content" placeholder="请输入回复内容">
             </textarea>
            </div>
        </div>
        <br><br><br>
        <div class="form-group">
            <div class="col-sm-10">
                <br><br><br>
                <button type="submit" class="btn btn-warning" style="width:80px;margin-left:50px">提交</button>
            </div>
        </div>
    </div>
</form>
    </div>
</div>
</body>
</html>
