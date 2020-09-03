<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/4/13
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>学生留言</title>
    <script>
        function go(loc) {
            window.location.href = loc;
        }
    </script>
</head>
<body>

    <jsp:include page="StudentNavigtionBar.jsp" />
    <div class="container-fluid" style="margin-bottom: 100px">
        <div class="row-fluid">
            <label class="radio-inline">
                <input type="radio" name="loc"  onClick="go('StudentLiuYan.jsp')" checked> 写留言
            </label>
            <label class="radio-inline">
                <input type="radio" name="loc"  onClick="go('ShowSearcherRelateMessage.jsp')"> 显示该课程留言
            </label>
            <br><br>

<form action="StudentLiuYanServlet.do" method="post">
            <div class="col-sm-8">
                <br><br><hr>
                <h4>留言</h4><br>
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
