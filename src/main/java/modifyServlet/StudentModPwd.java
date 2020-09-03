package modifyServlet;

import Dao.StudentDAO;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentModPwd", urlPatterns = {"/StudentModPwd"})
public class StudentModPwd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String newpassword1 = request.getParameter("newpassword1");
        Student student=new Student();
        StudentDAO dao=new StudentDAO();

        Student student1=new Student();
        student1= (Student) session.getAttribute("user");
        String id=student1.getAccount();
        String oldpassword1=student1.getPassword();
        if(oldpassword.equals(oldpassword1)&&newpassword.equals(newpassword1)){
            student.setAccount(id);
            student.setPassword(newpassword);
            if(dao.modPassword(student)!=null){
                student1.setPassword(newpassword);
                session.setAttribute("modpasswordisOk",1);
                session.setAttribute("user",student1);



            }
            else {
                session.setAttribute("modpasswordisOk", 2);
            }
        }
        else{
            session.setAttribute("modpasswordisOk",3);
        }
        response.sendRedirect("StudentModPwd.jsp");


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}