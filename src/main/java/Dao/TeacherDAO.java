package Dao;

import bean.Teacher;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO {
    DataSource ds = null;
    public TeacherDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
    public Teacher Teacher_check(String taccount, String password) throws SQLException {
        String sql="select * from teacher where taccount=? and password=?";
        Teacher teacher=new Teacher();
        Connection conn=null;
        PreparedStatement pstmt = null;
        try {
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,taccount);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                teacher.setAccount(rs.getString("taccount"));
                teacher.setPassword(rs.getString("password"));
                teacher.setSex(rs.getString("sex"));
                teacher.setName(rs.getString("name"));
                teacher.setPhone(rs.getLong("phoneNumber"));
                rs.close();
                pstmt.close();
                conn.close();
                return teacher;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Teacher modPassword(Teacher teacher){
        String sql="update teacher set password=? where taccount=?";
        try {
            Connection conn= ds.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getPassword());
            pstmt.setString(2,teacher.getAccount());
            int i=pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            if(i>0){
                return teacher;
            }
            else
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Teacher add(Teacher teacher) throws SQLException {
        String sql="";
        Connection conn=ds.getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        return new Teacher();
    }

    public Teacher mod(Teacher teacher){
        String sql="update teacher set sex=?,name=?,phoneNumber=? where taccount=?";
        try {
            Connection conn= ds.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getSex());
            pstmt.setString(2,teacher.getName());
            pstmt.setLong(3,teacher.getPhone());
            pstmt.setString(4,teacher.getAccount());
            int i=pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            if(i>0){
                return teacher;
            }
            else
                return null;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean delete(Teacher teacher) throws SQLException {
        String sql="";
        Connection conn=ds.getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        return false;
    }

    public ArrayList<Teacher> queryAll() throws SQLException {
        String sql="";
        Connection conn=ds.getConnection();
        PreparedStatement pstmt=conn.prepareStatement(sql);
        return new ArrayList<>();
    }
}
