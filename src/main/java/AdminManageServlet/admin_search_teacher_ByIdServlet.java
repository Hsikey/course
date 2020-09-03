package AdminManageServlet;

import bean.Student;
import bean.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin_search_teacher_ByIdServlet.do")
public class admin_search_teacher_ByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String taccount = request.getParameter("saccount");
        //获取session
        HttpSession session=request.getSession();
        ArrayList<Teacher> teachers= (ArrayList<Teacher>) session.getAttribute("TeachersList");
        boolean flag=false;
        for(int i = 0; i<teachers.size(); i++){
            if(teachers.get(i).getAccount().equals(taccount)){
                request.setAttribute("stus",teachers.get(i));
                flag=true;
            }
        }
        if(flag){
            request.setAttribute("type",0);
            RequestDispatcher rd = request.getRequestDispatcher("AdminManageTeachers.jsp");
            rd.forward(request, response);
        }else {
            request.setAttribute("type",-1);
            RequestDispatcher rd = request.getRequestDispatcher("AdminManageTeachers.jsp");
            rd.forward(request, response);
        }


    }
}
