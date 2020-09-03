package discussServlet;

import DAO2.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StuCourseServlet",urlPatterns = {"/StuCourse.do"})
public class StuCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取当前学生的学号
        HttpSession session=request.getSession();
        String saccount=(String)session.getAttribute("account");
        System.out.println("学生学号:"+saccount);
        String sql="select * from class where classId=(select classId from apply where saccount=?)";
        StudentDAO studentDAO=new StudentDAO();
        ArrayList list=studentDAO.StuCourse(sql,saccount);
        session.setAttribute("StuCourseList",list);
        response.sendRedirect("StuCourse.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
