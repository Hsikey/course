<%@ page import="bean.Student" %>
<%@ page import="bean.Class" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>查看资料</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>



<script language="javascript">
    function delcfm()
    {
        if (!confirm("确定删除？？"))
        {
            window.event.returnValue = false;
        }
    }
</script>

<body>
<%
    //获取当前班级的bean
    Class cls=(Class) session.getAttribute("ClsMess");
%>
<jsp:include page="StudentNavigtionBar.jsp" />

<div class="panel panel-info col-md-offset-1 col-md-10">
    <div class="panel-heading">
        <h3 align="center" class="panel-title">课程全部资料</h3>
    </div>
    <div class="panel-body">
        <c:forEach var="me" items="${fileNameMap}" >
            <div class="panel panel-success col-md-12">
                <div class="panel-body">
                    <c:url value="/DownLoadServlet.do" var="downurl">
                        <c:param name="filename" value="${me.key}"></c:param>
                    </c:url>

                        ${me.value}
                        <br>
                        <a href="${downurl}">下载</a>&nbsp;
                        &nbsp;&nbsp;

                    <br/>
                </div>
            </div>

        </c:forEach>

    </div>
</div>



<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
