<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/5/3
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示留言</title>
</head>

<body>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<jsp:include page="StudentNavigtionBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">

        <div class="col-sm-8"  style="background-color:	#FAEBD7;border-radius:10px;margin-left:20px;margin-top:20px;padding-bottom:30px;padding-left:30px">
            <br>
            <%--学生所查找的留言展示--%>
            <c:if test="${empty sessionScope.SearcherMessageList}}">
                <tr><td class> 没有相关留言</td></tr>
            </c:if>
            <%--<% response.setHeader("refresh","5;StuNewCount.do"); %>--%>
            <c:forEach var="mylist" items="${sessionScope.SearcherMessageList}">
                <c:if test="${mylist.id==sessionScope.r_m_no}">
                    <h3>${mylist.title}</h3>
                    <h5>${sessionScope.M_Username}&nbsp&nbsp&nbsp&nbsp发布于${mylist.putTime}</h5>
                    <h5>${mylist.content}</h5><br><br>

                    <form action="StuRespondLiuYan.do?disId=${mylist.id}" method="post">
                        <a href="javascript:;" class="reply_btn">回复</a>
                    </form>
                    <br>

                    <c:forEach var="rlist" items="${sessionScope.relist}">
                        <c:if test="${mylist.id==rlist.discussId}">
                            <div class="col-sm-11"  style="background-color:	#FFFFFF;border-radius:3px;margin-left:10px;margin-top:5px;padding-bottom:5px;padding-left:10px;padding-right:10px">
                                ${rlist.studentId}&nbsp&nbsp&nbsp&nbsp发布于${rlist.responseDate}
                                <h5>${rlist.content}</h5>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </div>


    </div>
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

