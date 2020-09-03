<%--
  Created by IntelliJ IDEA.
  User: 40835
  Date: 2020/5/12
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>学生课程</title>
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
            <div class="col-sm-8">
                <label class="radio-inline">
                    <input type="radio" name="loc"  onClick="go('StudentLiuYan.jsp')" checked> 写留言
                </label>
                <label class="radio-inline">
                    <input type="radio" name="loc"  onClick="go('StuCourseID.do')"> 显示该课程留言
                </label>
            </div>
    </div>
</div>

</body>
</html>
