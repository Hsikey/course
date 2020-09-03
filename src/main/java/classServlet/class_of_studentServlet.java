package classServlet;

import Dao.ClasDAO;
import bean.Class;
import bean.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/class_of_studentServlet.do")
public class class_of_studentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//获取session
        //获取当前学生的bean
        Student student = (Student) session.getAttribute("user");
        ClasDAO clasDAO=new ClasDAO();
        //得到当前学生自己的课表
        ArrayList<Class> ClsList=clasDAO.getOwnCls(student.getAccount());
        //存到session
        session.setAttribute("ClsList",ClsList);
        RequestDispatcher rd = request.getRequestDispatcher("StudentsHome.jsp");
        rd.forward(request, response);
    }
}
