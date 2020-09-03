package AdminManageServlet;

import Dao.AdministratorDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin_delete_teacherServlet.do")
public class admin_delete_teacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministratorDAO adminDao=new AdministratorDAO();
        String taccount =request.getParameter("saccount");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(adminDao.deleteTeacher(taccount)){
            RequestDispatcher rd = request.getRequestDispatcher("admin_search_all_teacherServlet.do");
            rd.forward(request, response);
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("admin_search_all_teacherServlet.do");
            rd.forward(request, response);
        }
    }
}
