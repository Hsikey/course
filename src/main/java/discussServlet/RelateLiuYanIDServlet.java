package discussServlet;

import DAO2.ResponseDAO;
import Dao.StudentDAO;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//浏览留言中 查看相关留言的id处理
@WebServlet(name = "RelateLiuYanIDServlet",urlPatterns = {"/RelateLiuYanID.do"})
public class RelateLiuYanIDServlet extends HttpServlet {
    private ResponseDAO respondDAO=new ResponseDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //编码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();

        ArrayList responds=null;
        responds=(ArrayList)session.getAttribute("RespondList");

        //获取传过来的信息
        int m_no=Integer.parseInt(request.getParameter("m_no"));
        String s_no=request.getParameter("s_no");
        System.out.println(s_no);

        String sql="select * from student where saccount=?";
        StudentDAO studentDAO=new StudentDAO();
        String username=null;
        try {
            ArrayList list=studentDAO.StudentMessage(sql,s_no);
            for(int i=0;i<list.size();i++){
                Student student=(Student)list.get(i);
                username=student.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        session.setAttribute("M_Username",username);
        session.setAttribute("relist",responds);
        session.setAttribute("r_m_no",m_no);
        response.sendRedirect("RelateSearcherLiuYan.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}