package Dao;

import bean.Administrator;
import bean.Student;
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

public class AdministratorDAO {
    DataSource ds = null;
    public AdministratorDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public Administrator Admin_check(String taccount, String password) throws SQLException {
        String sql="select * from administrator where adaccount=? and password=?";
        Administrator administrator=new Administrator();
        Connection conn=null;
        PreparedStatement pstmt = null;
        try {
            conn=ds.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,taccount);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
                administrator.setAccount(rs.getString("adaccount"));
                administrator.setPassword(rs.getString("password"));
                rs.close();
                pstmt.close();
                conn.close();
                return administrator;
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 管理员查看所有的学生信息
    public ArrayList<Student> getAllStudents(){
        String sql="SELECT * FROM student";
        ArrayList<Student> students=new ArrayList<Student>();
        Connection conn= null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setAccount(rs.getString(1));
                student.setName(rs.getString(4));
                student.setPassword(rs.getString(2));
                student.setPhone(rs.getLong(5));
                student.setSex(rs.getString(3));
                students.add(student);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return students;

        } catch (SQLException e) {
            e.printStackTrace();
            return students;
        }
    }

    //管理员根据账号删除学生
    public boolean deleteStudent(String saccount){
        String sql = "DELETE FROM student WHERE saccount=?";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,saccount);
            pstmt.execute();
            if(conn!=null){
                conn.close();
                conn=null;
            }
            return true;
        }catch(Exception se){
            return false;
        }
    }

    // 管理员查看所有的教师信息
    public ArrayList<Teacher> getAllTeachers(){
        String sql="SELECT * FROM teacher";
        ArrayList<Teacher> teachers=new ArrayList<Teacher>();
        Connection conn= null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Teacher teacher=new Teacher();
                teacher.setAccount(rs.getString(1));
                teacher.setName(rs.getString(4));
                teacher.setPassword(rs.getString(2));
                teacher.setPhone(rs.getLong(5));
                teacher.setSex(rs.getString(3));
                teachers.add(teacher);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return teachers;

        } catch (SQLException e) {
            e.printStackTrace();
            return teachers;
        }
    }

    //管理员根据账号删除教师
    public boolean deleteTeacher(String taccount){
        String sql = "DELETE FROM teacher WHERE taccount=?";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,taccount);
            pstmt.execute();
            if(conn!=null){
                conn.close();
                conn=null;
            }
            return true;
        }catch(Exception se){
            return false;
        }
    }

    //教师或者管理员添加教师
    public boolean addTeacher(Teacher teacher){
        String sql ="INSERT INTO teacher values(?,?,?,?,?)";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getAccount());
            pstmt.setString(2,teacher.getPassword());
            pstmt.setString(3,teacher.getSex());
            pstmt.setString(4,teacher.getName());
            pstmt.setLong(5,teacher.getPhone());
            pstmt.executeUpdate();
            if(conn!=null){
                conn.close();
                conn=null;
            }
            return true;
        }catch(Exception se){
            System.out.println(se);
            return false;
        }
    }

}
