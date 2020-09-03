package AdminManageServlet;

import Dao.AdministratorDAO;
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

@WebServlet("/admin_search_student_ByIdServlet.do")
public class admin_search_student_ByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String saccount = request.getParameter("saccount");
        //获取session
        HttpSession session=request.getSession();
        ArrayList<Student> students= (ArrayList<Student>) session.getAttribute("StudentsList");
        boolean flag=false;
        for(int i = 0; i<students.size(); i++){
            if(students.get(i).getAccount().equals(saccount)){
                request.setAttribute("stus",students.get(i));
                flag=true;
            }
        }
        if(flag){
            request.setAttribute("type",0);
            RequestDispatcher rd = request.getRequestDispatcher("AdminManageStudents.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("type",-1);
            RequestDispatcher rd = request.getRequestDispatcher("AdminManageStudents.jsp");
            rd.forward(request, response);
        }


    }
}
