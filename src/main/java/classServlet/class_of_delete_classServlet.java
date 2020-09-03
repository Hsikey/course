package classServlet;

import Dao.ClasDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/class_of_delete_classServlet.do")
public class class_of_delete_classServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClasDAO clasDAO=new ClasDAO();
        int classId=Integer.parseInt(request.getParameter("classId"));
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        if(clasDAO.deleteClass(classId)){
            RequestDispatcher rd = request.getRequestDispatcher("class_of_teacherServlet.do");
            rd.forward(request, response);
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("class_of_teacherServlet.do");
            rd.forward(request, response);
        }

    }
}
