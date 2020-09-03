package discussServlet;

import DAO2.baseDAO;
import bean.Class;
import bean.Discuss;
import bean.Teacher;

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

@WebServlet(name = "TeacherRespondServlet",urlPatterns = {"/t_respond.do"})
public class TeacherRespondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取当前操作人的身份
        HttpSession session=request.getSession();
        String saccount=null;
        Teacher teacher= new Teacher();
        teacher=(Teacher) session.getAttribute("user");
        String taccount=teacher.getAccount();
        System.out.println("教师："+taccount);

        //获取信息
        String content=request.getParameter("content");

        //留言时间
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resTime=sdf.format(d);
        System.out.println("当前系统的时间"+resTime);


        //获取c_no s_no a_no
        int disId=Integer.parseInt(request.getParameter("disId"));

        System.out.println("r_m_no=" +disId);
        int classId = 0;


        ArrayList list= null;
        list=(ArrayList)session.getAttribute("URMessage");
        if(list==null){
            System.out.println("评论测试为空");
        }
        for(int i=0;i<list.size();i++){
            Discuss m= (Discuss) list.get(i);
            int no=m.getId();
            if(no==disId){
                classId=m.getClassId();
                break;
            }
        }
        //更新
        baseDAO baseDAO=new baseDAO();
        String sql="insert into response(classId,disId,taccount,saccount,content,resTime) values(?,?,?,?,?,?)";
        try {
            int count=baseDAO.executeUpd(sql,classId,disId,taccount,saccount,content,resTime);
            if(count==1){//成功

                request.getRequestDispatcher("/showOneCourse.do").forward(request,response);

            }else{//失败
                    session.setAttribute("isOK",false);
                    response.sendRedirect("showOneCourse.do");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
