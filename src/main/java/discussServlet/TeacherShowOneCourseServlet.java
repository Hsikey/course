package discussServlet;

import Dao.*;
import DAO2.ResponseDAO;
import bean.Class;
import bean.Course;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//获取一个课程的所有相关信息
@WebServlet(name = "TeacherShowOneCourseServlet",urlPatterns = {"/showOneCourse.do"})
public class TeacherShowOneCourseServlet extends HttpServlet {
    private DiscussDAO messageDAO=new DiscussDAO();
    private ResponseDAO respondDAO=new ResponseDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String musername=null;
        String rusername=null;
        Class cls= new Class();
        cls=(Class)session.getAttribute("ClsMess");
        int classId=cls.getId();
        System.out.println("classid:"+classId);
        if(classId!=0){
            session.setAttribute("classId",classId);
        }else {
            classId= (int) session.getAttribute("classId");
        }
        ArrayList messages=new ArrayList();

        ArrayList responds=new ArrayList();


        //获得课程的所有留言信息
        String sql="select * from discuss where classId=?";
        messages=messageDAO.executeQry(sql,classId);

        //获得课程的所有回复信息
        responds=respondDAO.search_CNO(classId);

        session.setAttribute("URMessage",messages);
        session.setAttribute("r_list",responds);

        response.sendRedirect("TeacherOneCourse.jsp");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
