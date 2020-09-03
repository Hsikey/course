package classServlet;

import Dao.ClasDAO;
import bean.Class;
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

@WebServlet("/class_of_teacher_homeServlet.do")
public class class_of_teacher_homeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();//获取session
        //获取当前班级的id
        String id=request.getParameter("classId");
        ClasDAO clasDAO=new ClasDAO();
        ArrayList<Student> students=clasDAO.getAllStudents(id);
        session.setAttribute("StudentsList",students);
        Class cls=new Class();
        ArrayList<Class> classList= (ArrayList) session.getAttribute("ClsList");
        //根据id从集合中找出该班级
       for(int i=0;i<classList.size();i++){
           if(classList.get(i).getId()==Integer.parseInt(id))
                cls=classList.get(i);
       }
        session.setAttribute("ClsMess",cls);
        RequestDispatcher rd = request.getRequestDispatcher("TeacherHomePage.jsp");
        rd.forward(request, response);
    }
}
