package LAndR_Servlet;

import Dao.StudentDAO;
import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "lyx_Regist_Servlet",urlPatterns = "/lyx_Regist_Servlet")
public class lyx_Regist_Servlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String str = (request.getParameter("phonenumber"));
        long phonenumber;
        if(str.equals(""))
            phonenumber=0;
        else
            phonenumber= Long.parseLong(str);

        Student student = new Student();
        Student student1 = new Student();
        student1.setName(name);
        student1.setAccount(account);
        student1.setPassword(password);
        student1.setSex(sex);
        student1.setPhone(phonenumber);
        if (password == "") {
            request.setAttribute("registerisOK",3);
        } else {
            StudentDAO stu_regist = new StudentDAO();
            try {
                student = stu_regist.Student_check(account, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (student != null) {
                request.setAttribute("registerisOK",0);
            } else {
                student1 = stu_regist.Student_insert(student1);
                if (student1 != null) {
                    request.setAttribute("registerisOK",1);
                } else {
                    request.setAttribute("registerisOK",2);
                }
            }
        }
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
