package modifyServlet;

import Dao.StudentDAO;
import Dao.TeacherDAO;
import bean.Student;
import bean.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TeacherModPwd", urlPatterns = {"/TeacherModPwd"})
public class TeacherModPwd extends HttpServlet {
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
        Teacher teacher=new Teacher();
        TeacherDAO dao=new TeacherDAO();
        Teacher teacher1=new Teacher();
        teacher1= (Teacher) session.getAttribute("user");
        String id=teacher1.getAccount();
        String oldpassword1=teacher1.getPassword();
        if(oldpassword.equals(oldpassword1)&&newpassword.equals(newpassword1)){
            teacher.setAccount(id);
            teacher.setPassword(newpassword);
            if(dao.modPassword(teacher)!=null){
                teacher1.setPassword(newpassword);
                session.setAttribute("modpasswordisOk",1);
                session.setAttribute("user",teacher1);


            }
            else {
                session.setAttribute("modpasswordisOk", 2);
            }
        }
        else{
            session.setAttribute("modpasswordisOk",3);
        }
        response.sendRedirect("TeacherModPwd.jsp");


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}