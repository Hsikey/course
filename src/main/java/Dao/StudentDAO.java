package Dao;

import bean.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    DataSource ds = null;
    public StudentDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public Student modPassword(Student student){
        String sql="update student set password=? where saccount=?";
        try {
            Connection conn= ds.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,student.getPassword());
            pstmt.setString(2,student.getAccount());
            int i=pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            if(i>0){
                return student;
            }
            else
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student mod(Student student){
        String sql="update student set sex=?,name=?,phoneNumber=? where saccount=?";
        try {
            Connection conn= ds.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,student.getSex());
            pstmt.setString(2,student.getName());
            pstmt.setLong(3,student.getPhone());
            pstmt.setString(4,student.getAccount());
            int i=pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            if(i>0){
                return student;
            }
            else
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Student Student_check(String saccount, String password) throws SQLException {
        String sql="select * from student where saccount=? and password=?";
        Student student=new Student();
        Connection conn=null;
        PreparedStatement pstmt = null;
        try {
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,saccount);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                student.setAccount(rs.getString("saccount"));
                student.setPassword(rs.getString("password"));
                student.setSex(rs.getString("sex"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getLong("phoneNumber"));
                rs.close();
                pstmt.close();
                conn.close();
                return student;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Student Student_insert(Student student) {
        String sql = "insert into student(name,saccount,password,sex,phoneNumber)values(?,?,?,?,?)";
        Connection conn=null;
        PreparedStatement pstmt = null;
        try {
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getAccount());
            pstmt.setString(3,student.getPassword());
            pstmt.setString(4,student.getSex());
            pstmt.setLong(5,student.getPhone());
            int i=pstmt.executeUpdate();
            if(i>0) {
                return student;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Student> StudentMessage(String sql, String account) throws SQLException {
        Student student=new Student();
        Connection conn=null;
        ArrayList<Student> list=new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,account);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                Student s=new Student();
                s.setAccount(rs.getString("saccount"));
                s.setName(rs.getString("name"));
                s.setSex(rs.getString("sex"));
                s.setPhone(rs.getLong("phoneNumber"));
                s.setPassword(rs.getString("password"));
                list=list;
                list.add(s);
                return list;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }



}
