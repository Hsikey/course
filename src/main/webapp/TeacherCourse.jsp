<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: TTTxw
  Date: 2020/5/5
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>教师界面</title>
</head>
<body>
<jsp:include page="TeacherNavigationBar.jsp" />
<div class="container-fluid" style="margin-bottom: 100px">
    <div class="row-fluid">
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>课程名称</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <%--自己的留言--%>
                <c:if test="${empty sessionScope.t_course_list}">
                    <h4>尚无授课信息</h4>
                </c:if>
               <c:if test="${!empty sessionScope.t_course_list}">
                <c:forEach var="mylist" items="${sessionScope.t_course_list}">
                    <tr>
                    <td>${mylist.name}</td>
                    <td><a href="showOneCourse.do?classId=${mylist.classId}&taccount=${mylist.taccount}">查看</a></td>
                    </tr>
            </c:forEach>
            </c:if>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
