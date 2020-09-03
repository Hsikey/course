package classServlet;

import Dao.ClasDAO;
import bean.Class;
import bean.Student;
import bean.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "class_of_teacherServlet.do",urlPatterns = "/class_of_teacherServlet.do")
public class class_of_teacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//获取session
        //获取当前教师的bean
        Teacher teacher=(Teacher)session.getAttribute("user");
        ClasDAO clasDAO=new ClasDAO();
        //得到当前学生自己的课表
        ArrayList<Class> ClsList=clasDAO.getTeacherCls(teacher.getAccount());
        //存到session
        session.setAttribute("ClsList",ClsList);
        RequestDispatcher rd = request.getRequestDispatcher("TeachersHome.jsp");
        rd.forward(request, response);
    }
}
