package discussServlet;

import DAO2.StudentDAO;
import DAO2.baseDAO;
import bean.RandomID;
import bean.Student;
import bean.Class;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//保存学生留言servlet
@WebServlet(name = "StudentLiuYanServlet",urlPatterns = {"/StudentLiuYanServlet.do"})
public class StudentLiuYanServlet extends HttpServlet {
    /*  private static String m_id1="#";
      private static int m_id=2;*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取当前学生的学号 和留言的课程号
        HttpSession session=request.getSession();
        Student student =(Student)session.getAttribute("user");
        String saccount=student.getAccount();
        String taccount=null;
        String resId=null;
        Class cls= new Class();
        cls=(Class)session.getAttribute("ClsMess");
        int classId=cls.getId();


        //获取参数
        String title=request.getParameter("title");
        String content=request.getParameter("content");

//        String c_name=request.getParameter("c_name");


        //留言时间
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=sdf.format(d);
        System.out.println("当前系统的时间"+time);

        //查找改学生所属的学院
        //查找学生所属学院
        String sql1 = "select * from student where saccount=?";
        StudentDAO studentDAO = new StudentDAO();
        ArrayList list1 = null;
        try {
            list1 = studentDAO.StudentMessage(sql1, saccount);

            for (int i = 0; i < list1.size(); i++) {
                Student  student1 = (Student) list1.get(i);
                System.out.println("遍历学生");
            }
            //插入留言表中
            baseDAO baseDAO=new baseDAO();
            String sql2="insert into discuss(classId,taccount,saccount,title,content,putTime,resId) values(?,?,?,?,?,?,?)";
            try {
                int count=baseDAO.executeUpd(sql2,classId,taccount,saccount,title,content,time,resId);
                if(count==1){ //成功
                    request.getRequestDispatcher("/StudentLiuYan.jsp").forward(request,response);
                }else{
                    request.getRequestDispatcher("/StudentLiuYan.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

