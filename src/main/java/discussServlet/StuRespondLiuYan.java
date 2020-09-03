package discussServlet;

import DAO2.baseDAO;
import bean.Discuss;

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

//学生评论其他同学的留言
@WebServlet(name = "StuRespondLiuYan",urlPatterns = {"/StuRespondLiuYan.do"})
public class StuRespondLiuYan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //获取当前操作人的身份
        HttpSession session=request.getSession();
        String saccount=(String)session.getAttribute("account");
        String taccount=null;

        //获取信息
        String content=request.getParameter("content");

        //留言时间
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String resTime=sdf.format(d);
        System.out.println("当前系统的时间"+resTime);

        //获取c_no s_no a_no
        int disId=Integer.parseInt(request.getParameter("disId"));

      //  m_no=(String)session.getAttribute("r_m_no");
        System.out.println("r_m_no=" +disId);
        int classId = 0;


        ArrayList list= null;
        list=(ArrayList)session.getAttribute("SearcherMessageList");
        if(list==null){
            System.out.println("评论测试为空");
        }
        for(int i=0;i<list.size();i++){
            Discuss m= (Discuss) list.get(i);
            int no=m.getId();
            if(no==disId){
                classId=m.getClassId();
                saccount=m.getStudentId();
                break;
            }
        }
        //更新
        baseDAO baseDAO=new baseDAO();
        String sql="insert into response(classId,disId,taccount,saccount,content,resTime) values(?,?,?,?,?,?)";
        try {
            int count=baseDAO.executeUpd(sql,classId,disId,taccount,saccount,content,resTime);
            if(count==1){//成功
                response.sendRedirect("RelateSearcherLiuYan.jsp");
            }else{//失败
                response.sendRedirect("StuRespondLiuYan.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
