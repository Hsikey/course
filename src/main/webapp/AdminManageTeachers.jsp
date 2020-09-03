<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<script language="javascript">
    function delcfm()
    {
        if (!confirm("确定删除？？"))
        {
            window.event.returnValue = false;
        }
    }
</script>

<jsp:include page="AdminNavbar.jsp" />
<div class="panel panel-info col-md-offset-1 col-md-10">

    <div class="panel-heading">
        <h3 align="center" class="panel-title">教师列表</h3>
    </div>

    <div class="panel-body">
        <form action="admin_search_teacher_ByIdServlet.do" method="post"  class="bs-example bs-example-form" >
            <div class="input-group ">
                <input type="text" style="background-color:#F5F5F5" name="saccount" class="form-control " placeholder="输入学号查询">
                <span class="input-group-btn">
            <button  type="submit" class="inpu-group btn btn-info">查询</button>
                 </span>
            </div>
        </form>

        <c:if test="${type ==1 }">

            <c:forEach var="stus" items="${sessionScope.TeachersList}" varStatus="status" >
                <div class="panel panel-success col-md-3">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            账号：${stus.account}<br><br>
                            密码：${stus.password}<br><br>
                            姓名：${stus.name}<br><br>
                            性别：${stus.sex}<br><br>
                            电话：${stus.phone}
                        </h3>
                    </div>
                    <div class="panel-body">
                        <a  onclick='delcfm()' href="admin_delete_teacherServlet.do?saccount=${stus.account}" onMouseOver = "this.style.color = 'red'" onMouseOut = "this.style.color = ''  "><blink>删除</blink></a>
                    </div>
                </div>
            </c:forEach>
            <div class="panel panel-success col-md-3">
                <div class="panel-heading">
                    <h3 class="panel-title">.</h3>
                </div>
                <div class="panel-body">
                    <br><br>
                    <a href="AdminAddTeacher.jsp"><h1 align="center" >+</h1> </a>
                    <br><br>
                </div>
            </div>
        </c:if>

        <c:if test="${type==0}">
            <div class="panel panel-success col-md-3">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        账号：${stus.account}<br><br>
                        密码：${stus.password}<br><br>
                        姓名：${stus.name}<br><br>
                        性别：${stus.sex}<br><br>
                        电话：${stus.phone}
                    </h3>
                </div>
                <div class="panel-body">
                    <a  onclick='delcfm()' href="admin_delete_teacherServlet.do?saccount=${stus.account}" onMouseOver = "this.style.color = 'red'" onMouseOut = "this.style.color = ''  "><blink>删除</blink></a>
                </div>
            </div>
        </c:if>
        <c:if test="${type==-1}">

                    <div   class="alert alert-danger alert-dismissable col-md-offset-4 col-md-4">
                        <button type="button" class="close" data-dismiss="alert"
                                aria-hidden="true">
                            &times;
                        </button>
                        <span style="font-size:14px;text-align:center;display:block;">抱歉！没有查询到此教师！</span>
                    </div>

        </c:if>



    </div>
</div>

</body>
<script src="jquery.1.3.2.js" type="text/javascript"></script>
<script type="text/javascript">
    function confirmcheck(){
        if(confirm("确认退出吗？")){

            window.location.replace("login.jsp");
            return true;
        }else{
            return false;
        }
    }
</script>
</html>

