<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>班级信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>

<jsp:include page="TeacherNavigationBar.jsp" />

<div class="panel panel-info col-md-offset-1 col-md-10">
	<div class="panel-heading">
		<h3 align="center" class="panel-title">班级信息</h3>
	</div>
	<div class="panel-body">
	    课程名称：${sessionScope.ClsMess.name}<br>
		授课教师：${sessionScope.ClsMess.teacher}<br>
		开课时间：${sessionScope.ClsMess.startDate}~${sessionScope.ClsMess.endDate}<br>
		班级人数：${sessionScope.ClsMess.studentSum}

	</div>

</div>
<div class="panel panel-info col-md-offset-1 col-md-10">
	<div class="panel-heading">
		<h3 align="center" class="panel-title">班级成员表</h3>
	</div>
	<div class="panel-body">

        <c:forEach var="student" items= "${sessionScope.StudentsList}" >
        	    <div class="panel panel-success col-md-4">
                    	<div class="panel-heading">
                    		<h3 class="panel-title">${student.account}</h3>
                    	</div>
                    	<div class="panel-body">
                    		姓名：${student.name}<br>
                    		性别：${student.sex}<br>
                    		电话：${student.phone}

                    	</div>
            	</div>
        </c:forEach>
    </div>
</div>

</body>
</html>
