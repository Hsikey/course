package AdminManageServlet;

import Dao.AdministratorDAO;
import Dao.ClasDAO;
import bean.Class;
import bean.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/admin_add_teacherServlet.do")
public class admin_add_teacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Teacher teacher=new Teacher();
        AdministratorDAO administratorDAO=new AdministratorDAO();
        try {
            boolean flag;
            //获取教师工号
            teacher.setAccount(request.getParameter("taccount"));
            //获取教师名称
            teacher.setName(request.getParameter("name"));
            //获取教师性别
            teacher.setSex(request.getParameter("sex"));
            //获取教师密码
            teacher.setPassword(request.getParameter("password"));
            //获取教师电话
            if(request.getParameter("phone").equals(""))
                teacher.setPhone(0);
            else teacher.setPhone(Long.parseLong(request.getParameter("phone")));
            //判断获取的信息是否为空或者输入工号错误
            if(teacher.getAccount().equals("")||teacher.getPassword().equals(""))
                flag=false;
            else
                //数据库插入信息
                flag = administratorDAO.addTeacher(teacher);
            if (!flag) {
                //跳转错误界面
                request.setAttribute("addisOK",0);
                RequestDispatcher rd = request.getRequestDispatcher("AdminAddTeacher.jsp");
                rd.forward(request, response);
            } else if (flag) {
                //跳转正确界面
                request.setAttribute("addisOK",1);
                RequestDispatcher rd = request.getRequestDispatcher("AdminAddTeacher.jsp");
                rd.forward(request, response);
            }
        }catch(Exception e){
            //跳转错误界面
            request.setAttribute("addisOK",0);
            System.out.println(e);
            RequestDispatcher rd = request.getRequestDispatcher("AdminAddTeacher.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
