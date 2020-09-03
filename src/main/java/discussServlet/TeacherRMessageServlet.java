package discussServlet;

import DAO2.baseDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "TeacherRMessageServlet",urlPatterns = {"/t_readMessage.do"})
public class TeacherRMessageServlet extends HttpServlet {
    DAO2.baseDAO baseDAO=new baseDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        session.setAttribute("isOK",null);
        String t_no=(String)session.getAttribute("number");
        String sql="Update t_messagejudge set flag=1 where t_no=?";
        String sql1="Update discussion set flag=1 where to_uid=?";
        try {
            int count=baseDAO.executeUpd(sql,t_no);
            count+=baseDAO.executeUpd(sql1,t_no);
            if(count>0){
                System.out.println("success");
                response.sendRedirect("TeacherURMessage.jsp");
            }else {
                session.setAttribute("idOK",false);
                response.sendRedirect("TeacherHomePage.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
