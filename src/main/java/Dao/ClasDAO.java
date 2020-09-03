package Dao;

import bean.Apply;
import bean.Class;
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

public class ClasDAO {
    DataSource ds = null;

    public ClasDAO() {
        try {
            Context context = new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    // 根据学号查看学生当前正在学的课程
    public ArrayList<Class> getOwnCls(String saccount) {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM student AS a,class AS b,teacher AS c,apply AS d \n" +
                "WHERE a.`saccount`=d.`saccount` AND d.`classId`=b.`classId` AND b.`taccount`=c.`taccount` AND a.`saccount`=?";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, saccount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class studentCls = new Class();
                studentCls.setName(rs.getString(1));
                studentCls.setTeacher(rs.getString(2));
                studentCls.setStudentSum(rs.getInt(3));
                studentCls.setStartDate(rs.getDate(4));
                studentCls.setEndDate(rs.getDate(5));
                studentCls.setId(rs.getInt(6));
                studentCls.setStudentId(rs.getInt(7));
                studentCls.setNotificationId(rs.getInt(8));
                studentCls.setDiscussId(rs.getInt(9));
                studentCls.setSignId(rs.getInt(10));
                studentCls.setTaskId(rs.getInt(11));
                clss.add(studentCls);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return clss;

        } catch (SQLException e) {
            e.printStackTrace();
            return clss;
        }
    }

    // 查看所有正在开设的课程
    public ArrayList<Class> getAllCls() {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM class AS b,teacher AS c \n" +
                "WHERE b.`taccount`=c.`taccount`";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class studentCls = new Class();
                studentCls.setName(rs.getString(1));
                studentCls.setTeacher(rs.getString(2));
                studentCls.setStudentSum(rs.getInt(3));
                studentCls.setStartDate(rs.getDate(4));
                studentCls.setEndDate(rs.getDate(5));
                studentCls.setId(rs.getInt(6));
                studentCls.setStudentId(rs.getInt(7));
                studentCls.setNotificationId(rs.getInt(8));
                studentCls.setDiscussId(rs.getInt(9));
                studentCls.setSignId(rs.getInt(10));
                studentCls.setTaskId(rs.getInt(11));
                clss.add(studentCls);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return clss;

        } catch (SQLException e) {
            e.printStackTrace();
            return clss;
        }
    }

    // 查看学生当前正在学的课程
    public ArrayList<Class> getTeacherCls(String saccount) {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM class AS b,teacher AS c \n" +
                "WHERE b.`taccount`=c.`taccount` AND b.`taccount`=?";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, saccount);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Class studentCls = new Class();
                studentCls.setName(rs.getString(1));
                studentCls.setTeacher(rs.getString(2));
                studentCls.setStudentSum(rs.getInt(3));
                studentCls.setStartDate(rs.getDate(4));
                studentCls.setEndDate(rs.getDate(5));
                studentCls.setId(rs.getInt(6));
                studentCls.setStudentId(rs.getInt(7));
                studentCls.setNotificationId(rs.getInt(8));
                studentCls.setDiscussId(rs.getInt(9));
                studentCls.setSignId(rs.getInt(10));
                studentCls.setTaskId(rs.getInt(11));
                clss.add(studentCls);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return clss;

        } catch (SQLException e) {
            e.printStackTrace();
            return clss;
        }
    }

    // 根据课程编号得到所有的学生信息
    public ArrayList<Student> getAllStudents(String id) {
        String sql = "SELECT b.`saccount`,b.`name`,b.`password`,b.`phoneNumber`,b.`sex`\n" +
                "FROM apply AS a,student AS b\n" +
                "WHERE a.`saccount`=b.`saccount` AND a.`classId`=?";
        ArrayList<Student> students = new ArrayList<Student>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setAccount(rs.getString(1));
                student.setName(rs.getString(2));
                student.setPassword(rs.getString(3));
                student.setPhone(rs.getLong(4));
                student.setSex(rs.getString(5));
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

    public int checkClassId() {
        String sql ="select max(classId) from class";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int classId = 0;
            if (rs.next()) {
                classId = rs.getInt("max(classId)");
                classId = classId + 1;
            }
            if(conn!=null){
                conn.close();
                conn=null;
            }
            return classId;
        }catch(Exception se){
            return 0;
        }
    }

    //教师或者管理员添加课程
    public boolean addClass(Class cls){
        String sql ="INSERT INTO class values(?,?,?,?,?,0,0,0,0,0,0)";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, checkClassId());
            pstmt.setString(2,cls.getTeacher());
            pstmt.setString(3,cls.getName());
            pstmt.setDate(4,cls.getStartDate());
            pstmt.setDate(5,cls.getEndDate());
            pstmt.executeUpdate();

            if(conn!=null){
                conn.close();
                conn=null;
            }
            return true;
        }catch(Exception se){
            return false;
        }
    }

    //教师或者管理员删除课程
    public boolean deleteClass(int classId){
        String sql = "DELETE FROM class WHERE classId =?";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,classId);
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

    //教师修改班级的信息
    public boolean updateClass(Class cls){
        String sql = "update class SET name=?,startDate=?,endDate=? where classId=?";
        try{
            Connection conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,cls.getName());
            pstmt.setDate(2,cls.getStartDate());
            pstmt.setDate(3,cls.getEndDate());
            pstmt.setInt(4,cls.getId());
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

    public ArrayList<Apply> getAllApply() {
        String sql = "SELECT * from apply";
        ArrayList<Apply> applys = new ArrayList<Apply>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setStudentId(rs.getString(1));
                apply.setClassId(rs.getInt(2));
                apply.setId(rs.getInt(3));
                applys.add(apply);
            }
            rs.close();
            pstmt.close();
            conn.close();
            return applys;

        } catch (SQLException e) {
            e.printStackTrace();
            return applys;
        }
    }

    public boolean register(String studentId,int classId) {
        String sql = "insert into apply(saccount,classId) values(?,?)";
        String sql2= "update class set studentSum=studentSum+1 where classId=?";
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt2=conn.prepareStatement(sql2);
            pstmt.setString(1,studentId);
            pstmt.setInt(2,classId);
            int i=pstmt.executeUpdate();
            pstmt2.setInt(1,classId);
            int j=pstmt2.executeUpdate();

            if(i>0)
                return true;
            else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
