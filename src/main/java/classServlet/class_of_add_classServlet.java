package classServlet;

import Dao.ClasDAO;
import bean.Class;
import bean.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/class_of_add_classServlet.do")
public class class_of_add_classServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();//获取session
        //获取当前教师的bean
        Teacher teacher=(Teacher)session.getAttribute("user");
        ClasDAO clasDAO=new ClasDAO();
        Class cls=new Class();
        try {
            boolean flag;
            //获取教师工号
            cls.setTeacher(teacher.getAccount());
            //获取班级课程
            cls.setName(request.getParameter("name"));
            //获取开始时间
            java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
            cls.setStartDate(startDate);
            //获取结束时间
            java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
            cls.setEndDate(endDate);
            //判断获取的信息是否为空或者输入工号错误
            if(cls.getTeacher().equals("")||!cls.getTeacher().equals(teacher.getAccount())||cls.getName().equals("")
                    ||cls.getStartDate().equals("")||cls.getEndDate().equals("")) {
                flag = false;
            } else
                //数据库插入信息
                flag = clasDAO.addClass(cls);
            if (!flag) {
                //跳转错误界面
                request.setAttribute("addisOK",0);
                RequestDispatcher rd = request.getRequestDispatcher("TeacherAddClass.jsp");
                rd.forward(request, response);
            } else if (flag) {
                //跳转正确界面
                request.setAttribute("addisOK",1);
                RequestDispatcher rd = request.getRequestDispatcher("TeacherAddClass.jsp");
                rd.forward(request, response);
            }
        }catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("TeacherAddClass.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
