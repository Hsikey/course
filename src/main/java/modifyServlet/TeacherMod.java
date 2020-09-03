package modifyServlet;

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

@WebServlet(name = "TeacherMod", urlPatterns = {"/TeacherMod"})
public class TeacherMod extends HttpServlet {
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
        Teacher teacher=new Teacher();
        TeacherDAO dao=new TeacherDAO();
        Teacher teacher1=new Teacher();
        teacher1= (Teacher) session.getAttribute("user");
        String id=teacher1.getAccount();
        //将信息封装成teacher类
        teacher.setAccount(id);
        teacher.setName(name);
        teacher.setSex(sex);
        teacher.setPhone(phone);
        if(dao.mod(teacher)!=null){
            session.setAttribute("modisOk",1);
            teacher1.setName(name);
            teacher1.setPhone(phone);
            teacher1.setSex(sex);
            session.setAttribute("user",teacher1);



        }
        else {
                session.setAttribute("modisOk", 2);
        }
        response.sendRedirect("TeacherMod.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}