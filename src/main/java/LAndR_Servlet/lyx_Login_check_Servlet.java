package LAndR_Servlet;

import Dao.AdministratorDAO;
import Dao.StudentDAO;
import Dao.TeacherDAO;
import bean.Administrator;
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
import java.security.interfaces.RSAKey;
import java.sql.SQLException;

@WebServlet(name = "lyx_Login_check_Servlet",urlPatterns = "/lyx_Login_check_Servlet")
public class lyx_Login_check_Servlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.invalidate();
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String type = request.getParameter("role");
        Teacher teacher=new Teacher();
        Student student=new Student();
        Administrator administrator=new Administrator();
        HttpSession session = request.getSession();

        StudentDAO stu_login=new StudentDAO();
        AdministratorDAO ad_login=new AdministratorDAO();
        TeacherDAO tea_login=new TeacherDAO();

        if (type.equals("student")) {
            try {
                student = stu_login.Student_check(account,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (student!=null) {
                session.setAttribute("user",student);
                response.sendRedirect("/course/class_of_studentServlet.do");
            } else {
                request.setAttribute("loginisOK",0);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (type.equals("administrator")) {
            try {
                administrator=ad_login.Admin_check(account,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (administrator!=null) {
                session.setAttribute("user",administrator);
                response.sendRedirect("AdminNavbar.jsp");
            } else {
                request.setAttribute("loginisOK",0);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (type.equals("teacher")) {
            try {
                teacher = tea_login.Teacher_check(account,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (teacher!=null) {
                session.setAttribute("user",teacher);
                response.sendRedirect("/course/class_of_teacherServlet.do");
            } else {
                request.setAttribute("loginisOK",0);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }
}
