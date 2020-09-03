<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: 赵佳桃
  Date: 2020/5/3
  Time: 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言列表</title>
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
                <input type="radio" name="loc"  onClick="go('StudentLiuYan.jsp')" > 写留言
            </label>
            <label class="radio-inline">
                <input type="radio" name="loc"  onClick="go('ShowSearcherRelateMessage.jsp')" checked> 显示该课程留言
            </label>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>标题</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty sessionScope.SearcherMessageList}">
                    <tr><td class> 没有相关留言</td></tr>
                </c:if>
                <c:forEach var="mylist" items="${sessionScope.SearcherMessageList}">
                    <tr>

                        <td><a href="RelateLiuYanID.do?m_no=${mylist.id}&s_no=${mylist.studentId}">${mylist.title}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>
</div>
</body>
</html>
