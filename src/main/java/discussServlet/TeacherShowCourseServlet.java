package discussServlet;

import DAO2.CourseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TeacherShowCourseServlet",urlPatterns = {"/showT_Course.do"})
public class TeacherShowCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //获取当前教师账号
        CourseDAO courseDAO=new CourseDAO();
        HttpSession session=request.getSession();
        String t_no=(String)session.getAttribute("account");
        System.out.println("老师账号"+t_no);
        ArrayList list=null;
        String sql="select * from class where taccount=?";
        list= courseDAO.searchTNO(sql,t_no);
        session.setAttribute("t_course_list",list);
        response.sendRedirect("TeacherCourse.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
