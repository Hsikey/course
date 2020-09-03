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

@WebServlet(name = "StudentMod", urlPatterns = {"/StudentMod"})
public class StudentMod extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        //获取最新信息
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        Long phone = Long.valueOf(request.getParameter("phone"));
        Student student=new Student();
        StudentDAO dao=new StudentDAO();
        Student student1=new Student();
        student1= (Student) session.getAttribute("user");
        String id=student1.getAccount();
        //将信息封装成student类
        student.setAccount(id);
        student.setName(name);
        student.setSex(sex);
        student.setPhone(phone);
        if(dao.mod(student)!=null){
            session.setAttribute("modisOk",1);
            student1.setName(name);
            student1.setPhone(phone);
            student1.setSex(sex);
            session.setAttribute("user",student1);


        }
        else {
                session.setAttribute("modisOk", 2);
        }
        response.sendRedirect("StudentMod.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}