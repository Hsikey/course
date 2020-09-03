package DAO2;

import bean.Discuss;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscussDAO {
    baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    StudentDAO studentDAO=new StudentDAO();
    TeacherDAO teacherDAO=new TeacherDAO();
    int count=0;//影响表的行数
    /*获取所有主留言*/
    public ArrayList search()  {
        ArrayList<Discuss> list=new ArrayList<>();
        String sql="select * from discuss";
        try {
            rs=baseDAO.executeQry(sql);
            while(rs.next()){
                Discuss m=new Discuss();
                m.setId(rs.getInt("disId"));
                m.setTitle(rs.getString("title"));
                m.setContent(rs.getString("content"));
                System.out.println(rs.getString("content"));
                m.setPutTime(rs.getDate("putTime"));
                m.setClassId(rs.getInt("classId"));
                m.setStudentId(rs.getString("saccount"));
                m.setTeacherId(rs.getString("taccount"));
                m.setReponseId(rs.getInt("resId"));
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

       //按课程号来找
    public ArrayList C_MessageQry(String sql,int no) throws SQLException {
        ArrayList<Discuss> list=new ArrayList<>();
        rs=baseDAO.executeQry(sql,no);
        while(rs.next()){
            Discuss m=new Discuss();
            m.setId(rs.getInt("disId"));
            m.setTitle(rs.getString("title"));
            m.setContent(rs.getString("content"));
            System.out.println(rs.getString("content"));
            m.setPutTime(rs.getDate("putTime"));
            m.setClassId(rs.getInt("classId"));
            m.setStudentId(rs.getString("saccount"));
            m.setTeacherId(rs.getString("taccount"));
            m.setReponseId(rs.getInt("resId"));
            String saccount=m.getStudentId();
            String taccount=m.getTeacherId();
            list=list;
            list.add(m);
        }
        return list;
    }

    //按照学生学号来查找
    public ArrayList SMessageQry(String sql,String s_no) throws SQLException {
        ArrayList<Discuss> list=new ArrayList<>();
        rs=baseDAO.executeQry(sql,s_no);
        while(rs.next()){
            Discuss m=new Discuss();
            m.setId(rs.getInt("disId"));
            m.setTitle(rs.getString("title"));
            m.setContent(rs.getString("content"));
            System.out.println(rs.getString("content"));
            m.setPutTime(rs.getDate("putTime"));
            m.setClassId(rs.getInt("classId"));
            m.setStudentId(rs.getString("saccount"));
            m.setTeacherId(rs.getString("taccount"));
            m.setReponseId(rs.getInt("resId"));
            list=list;
            list.add(m);
        }
        return list;
    }

    //按照关键字来查找
    public ArrayList KeyWordMessageQry(String sql,String content,String content1) throws SQLException {
        ArrayList<Discuss> list=new ArrayList<>();
        rs=baseDAO.executeQry(sql,content,content1);
        while(rs.next()){
            Discuss m=new Discuss();
            m.setId(rs.getInt("disId"));
            m.setTitle(rs.getString("title"));
            m.setContent(rs.getString("content"));
            System.out.println(rs.getString("content"));
            m.setPutTime(rs.getDate("putTime"));
            m.setClassId(rs.getInt("classId"));
            m.setStudentId(rs.getString("saccount"));
            m.setTeacherId(rs.getString("taccount"));
            m.setReponseId(rs.getInt("resId"));
            list=list;
            list.add(m);
        }
        return list;
    }


}
