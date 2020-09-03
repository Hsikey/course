<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TTTxw
  Date: 2020/5/5
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教师界面</title>
    <script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
</head>
<body>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<jsp:include page="TeacherNavigationBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">
        <div class="col-sm-8">

    <tr><h3>${sessionScope.onecourse.name}</h3></tr>

<hr>

<c:forEach var="mlist" items="${sessionScope.URMessage}">
    <div class="col-sm-8"  style="background-color:	#FAEBD7;border-radius:10px;margin-left:20px;margin-top:20px;padding-bottom:30px;padding-left:30px">
        <tr>
            <h3>${mlist.title}</h3>
            ${mlist.studentId}&nbsp&nbsp&nbsp&nbsp发布于${mlist.putTime}
            <h5>${mlist.content}</h5><br>
        </tr>
        <form action="t_respond.do?disId=${mlist.id}" method="post">
            <a href="javascript:;" class="reply_btn">回复</a>
        </form>
        </tr>
        <c:forEach var="rlist" items="${sessionScope.r_list}">
        <c:if test="${mlist.id eq rlist.discussId}">
            <div class="col-sm-11"  style="background-color:	#FFFFFF;border-radius:3px;margin-left:10px;margin-top:5px;padding-bottom:5px;padding-left:10px;padding-right:10px">
                    <c:if test="${rlist.teacherId==null}">
                         ${rlist.studentId}
                    </c:if>
                    <c:if test="${rlist.teacherId!=null}">
                         ${rlist.teacherId}
                    </c:if>
                    &nbsp&nbsp&nbsp&nbsp发布于${rlist.responseDate}
                    <h5>${rlist.content}</h5>
            </div>
        </c:if>
    </c:forEach>
    </div>
</c:forEach>


</div>
</body>


<script type="text/javascript">
    $(function(){
        //页面加载完毕后开始执行的事件
        $(".reply_btn").click(function(){
            $(this).parent().append(
                "<table><tr><td>内容：</td><td><input type=\"text\" name=\"content\" ></td>        </tr>        \n" +
                "<tr><td><input type=\"submit\" value=\"确定\"></td><td><input type=\"reset\" value=\"取消\"></td></tr></table>");
        });
    });
</script>
</html>
