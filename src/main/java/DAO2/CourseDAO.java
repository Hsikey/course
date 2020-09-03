package DAO2;

import bean.Course;
import bean.Discuss;
import bean.Response;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class CourseDAO {
    baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    int count=0;//影响表的行数
    DataSource ds = null;
    public CourseDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }


    //通过课程id查找课程信息
    public Course onesearch_CNO(int no){
        String sql="select * from class where classId=?";
        ResultSet rs=null;
        Course course=new Course();
        Connection conn=null;
        ArrayList<Discuss> list=new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            rs=baseDAO.executeQry(sql,no);
            if(rs.next()){
                course.setClassId(rs.getInt("classId"));
                course.setName(rs.getString("name"));
                course.setTaccount(rs.getString("taccount"));
                course.setStartDate(rs.getDate("startDate"));
                course.setEndDate(rs.getDate("endDate"));
                course.setStudentSum(rs.getInt("studentSum"));
                course.setStudentId(rs.getInt("studentId"));
                course.setNotificationId(rs.getInt("notificationId"));
                course.setSignId(rs.getInt("signId"));
                course.setDiscussId(rs.getInt("discussId"));
                course.setTaskId(rs.getInt("taskId"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }





    //通过教师账号搜索授课信息
    public ArrayList searchTNO(String sql,String tno){
        ArrayList<Course> list=new ArrayList<>();

        ResultSet rs=null;
        try{
            rs=baseDAO.executeQry(sql,tno);
            while (rs.next()){
                Course course=new Course();
                course.setClassId(rs.getInt("classId"));
                course.setName(rs.getString("name"));
                course.setTaccount(rs.getString("taccount"));
                course.setStartDate(rs.getDate("startDate"));
                course.setEndDate(rs.getDate("endDate"));
                course.setStudentSum(rs.getInt("studentSum"));
                course.setStudentId(rs.getInt("studentId"));
                course.setNotificationId(rs.getInt("notificationId"));
                course.setSignId(rs.getInt("signId"));
                course.setDiscussId(rs.getInt("discussId"));
                course.setTaskId(rs.getInt("taskId"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
