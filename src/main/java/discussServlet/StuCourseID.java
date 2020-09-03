package discussServlet;

import Dao.DiscussDAO;
import DAO2.ResponseDAO;
import bean.Class;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//id 中转站
@WebServlet(name = "StuCourseID",urlPatterns = {"/StuCourseID.do"})
public class StuCourseID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session=request.getSession();
        Class cls= new Class();
        cls=(Class)session.getAttribute("ClsMess");
        int no=cls.getId();


        ArrayList list1=null;
        String title=null;
        String content=null;
            DiscussDAO messageDAO=new DiscussDAO();
            ResponseDAO responseDAO=new ResponseDAO();
            ArrayList list=null;
            ArrayList responds=new ArrayList();
            String sql="select * from discuss where classId=?";
        list= messageDAO.executeQry(sql,no);
        responds=responseDAO.search_CNO(no);
        session.setAttribute("SearcherMessageList",list);
        session.setAttribute("RespondList",responds);
        response.sendRedirect("ShowSearcherRelateMessage.jsp");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

