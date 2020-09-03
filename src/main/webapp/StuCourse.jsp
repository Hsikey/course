<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/5/1
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>浏览课程</title>
</head>
<body>
<jsp:include page="StudentNavigtionBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>课程</th>
                 </tr>
                </thead>
                <tbody>
                <c:if test="${empty sessionScope.StuCourseList}">
                    <h5>暂无课程，请先选课！</h5>
                </c:if>
                <c:forEach var="mylist" items="${sessionScope.StuCourseList}">
                    <tr>
                        <td><a href="StuCourseID.do?no=${mylist.id}&judge=course">${mylist.name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>


</body>
</html>
