<%--@elvariable id="mylist" type="JavaBean.Academy"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: TTTxw
  Date: 2020/5/5
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="http://cdn.bootcss.com/jquery/2.2.4/jquery.js"></script>
</head>
<body>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<jsp:include page="TeacherNavigationBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">

<c:if test="${!empty sessionScope.isOK}">
    <c:if test="${sessionScope.isOK}">
        <script type="text/javascript" language="javascript">
            alert("回复成功");
        </script>
    </c:if>
    <c:if test="${!sessionScope.isOK}">
        <script type="text/javascript" language="javascript">
            alert("回复失败");
        </script>
    </c:if>
</c:if>


    <c:if test="${empty sessionScope.URMessage and empty sessionScope.URDisussion}">
        <h4>尚无新留言</h4>
    </c:if>
    <c:if test="${!empty sessionScope.URMessage}">
        <c:forEach var="mylist" items="${sessionScope.URMessage}">
        <div class="col-sm-8"  style="background-color:	#FAEBD7;border-radius:10px;margin-left:20px;margin-top:20px;padding-bottom:30px;padding-left:30px">
            <tr>
                <h3>${mylist.title}</h3>
                用户${mylist.name}&nbsp&nbsp&nbsp&nbsp发布于${mylist.time}
                <h5>${mylist.content}</h5><br>
            </tr>
            <tr><i class="fa fa-heart-o" aria-hidden="true"></i>${mylist.good}</tr>
            <form action="t_respond.do?m_no=${mylist.no}&id=1" method="post">
            <tr><a href="javascript:;" class="reply_btn">回复</a></tr>
            </form>
        </c:forEach>
        </div>
    </c:if>


    <c:if test="${!empty sessionScope.URDisussion}">
        <c:forEach var="dlist" items="${sessionScope.URDisussion}">
            <div class="col-sm-8"  style="background-color:	#FFFFFF;border-radius:10px;margin-left:20px;margin-top:20px;padding-bottom:30px;padding-left:30px">
                <tr>
                     ${dlist.fname}回复用户${dlist.tname}&nbsp&nbsp&nbsp&nbsp于${dlist.d_time}
                    <h5>${dlist.d_content}</h5><br>
                </tr>
                <form action="teacherdiscussion.do?r_no=${dlist.r_no}&r_id=${dlist.from_uid}&id=2" method="post">
                    <tr><a href="javascript:;" class="reply_btn2">回复</a></tr>
                </form>
            </div>
        </c:forEach>
    </c:if>
    </div>
</div>
</body>

<script type="text/javascript">
    $(function(){
        //页面加载完毕后开始执行的事件
        $(".reply_btn").click(function(){
            $(".reply_textarea").remove();
            $(this).parent().append(


                "<table><tr><td>标题：</td><td><input type=\"text\" name=\"title\" ></td></tr><tr><td>内容：</td><td><input type=\"text\" name=\"content\" ></td>        </tr>        \n" +
                "<tr><td><input type=\"submit\" value=\"确定\"></td><td><input type=\"reset\" value=\"取消\"></td></tr></table>");
        });
        $(".reply_btn2").click(function(){
            $(this).parent().append(
                "<table><tr><td>内容：</td><td><input type=\"text\" name=\"d_content\" ></td>        </tr>        \n" +
                "<tr><td><input type=\"submit\" value=\"确定\"></td><td><input type=\"reset\" value=\"取消\"></td></tr></table>");
        });
    });
</script>
</html>

