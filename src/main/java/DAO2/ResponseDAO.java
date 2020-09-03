package DAO2;

import bean.DateUtil;
import bean.Response;
import bean.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class ResponseDAO {
    DAO2.baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    StudentDAO studentDAO=new StudentDAO();
    TeacherDAO teacherDAO=new TeacherDAO();
    int count=0;//影响表的行数
    DataSource ds = null;
    public ResponseDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    //根据查找回复
    public ArrayList NewRespond(String sql, String no){
        ArrayList<Response> list=new ArrayList<>();
        try{
            rs=baseDAO.executeQry(sql,no);
            while(rs.next()){
                Response r=new Response();
                r.setContent(rs.getString("content"));
                System.out.println(rs.getString("content"));
                Timestamp timestamp=rs.getTimestamp("resTime");
                Date date=  new  Date(timestamp.getTime());
                DateUtil dataUtil=new DateUtil();
                String time=dataUtil.date2String(date);
                r.setResponseDate(rs.getDate("resTime"));
                r.setId(rs.getInt("resId"));
                r.setStudentId(rs.getString("saccount"));
                r.setTeacherId(rs.getString("taccount"));
                r.setDiscussId(rs.getInt("disId"));
                r.setClassId(rs.getInt("classId"));
                String saccount=r.getStudentId();
                String taccount=r.getTeacherId();
                list=list;
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  list;

    }
    //根据课程id查找回复
    public ArrayList search_CNO(int c_no){
        String sql="select * from response where classId=?";
        Connection conn=null;
        ArrayList<Response> list=new ArrayList<>();
        PreparedStatement pstmt = null;
        try{
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,c_no);
            ResultSet rs=pstmt.executeQuery();
            while(rs.next()){
                Response r=new Response();
                r.setContent(rs.getString("content"));
                System.out.println(rs.getString("content"));
                r.setResponseDate(rs.getDate("resTime"));
                r.setId(rs.getInt("resId"));
                r.setStudentId(rs.getString("saccount"));
                r.setTeacherId(rs.getString("taccount"));
                r.setDiscussId(rs.getInt("disId"));
                r.setClassId(rs.getInt("classId"));
                String saccount=r.getStudentId();
                String taccount=r.getTeacherId();
                list=list;
                list.add(r);
            }
        } catch (SQLException e) {
            System.out.println("searchCNO错误");
            e.printStackTrace();
        }
        return  list;

    }

}
