package classServlet;

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

@WebServlet("/class_of_update_classServlet.do")
public class class_of_update_classServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取当前教师的bean
        ClasDAO clasDAO=new ClasDAO();
        Class cls=new Class();
        try {
            boolean flag=false;
            //获取班级编号
            int Id=Integer.parseInt(request.getParameter("classId"));
            cls.setId(Id);
            String name=request.getParameter("name");
            //获取班级课程
            cls.setName(name);
            //判断获取的信息是否为空错误
            if(cls.getName().equals("")||request.getParameter("startDate").equals("")||request.getParameter("endDate").equals("")){
                request.setAttribute("addisOK",0);
                RequestDispatcher rd = request.getRequestDispatcher("TeacherUpdateClass.jsp");
                rd.forward(request, response);
            } else {//数据库插入信息
                //获取开始时间
                java.sql.Date startDate = java.sql.Date.valueOf(request.getParameter("startDate"));
                cls.setStartDate(startDate);
                //获取结束时间
                java.sql.Date endDate = java.sql.Date.valueOf(request.getParameter("endDate"));
                cls.setEndDate(endDate);
                flag = clasDAO.updateClass(cls);
            }
            if (flag) { 
                //跳转正确界面
                request.setAttribute("addisOK",1);
                RequestDispatcher rd = request.getRequestDispatcher("TeacherUpdateClass.jsp");
                rd.forward(request, response);
            }
        } catch(Exception e){
            request.setAttribute("addisOK",0);
            RequestDispatcher rd = request.getRequestDispatcher("TeacherUpdateClass.jsp");
            rd.forward(request, response);
        }
    }
}
