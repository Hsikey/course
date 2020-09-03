package DAO2;

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
    baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;

    // 根据学号查看学生当前正在学的课程
    public ArrayList<Class> getOwnCls(String saccount) {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM student AS a,class AS b,teacher AS c,apply AS d \n" +
                "WHERE a.`saccount`=d.`saccount` AND d.`classId`=b.`classId` AND b.`taccount`=c.`taccount` AND a.`saccount`=?";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            //conn = ds.getConnection();
            //PreparedStatement pstmt = conn.prepareStatement(sql);
            //pstmt.setString(1, saccount);
            ResultSet rs = baseDAO.executeQry(sql,saccount);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clss;
    }

    // 查看所有正在开设的课程
    public ArrayList<Class> getAllCls() {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM class AS b,teacher AS c \n" +
                "WHERE b.`taccount`=c.`taccount`";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            ResultSet rs = baseDAO.executeQry(sql);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } return clss;
    }

    // 查看学生当前正在学的课程
    public ArrayList<Class> getTeacherCls(String saccount) {
        String sql = "SELECT b.`name`,c.`name`,b.`studentSum`,b.`startDate`,b.`endDate`,b.`classId`,b.`studentId`,b.`notificationId`,b.`discussId`,b.`signId`,b.`taskId`\n" +
                "FROM class AS b,teacher AS c \n" +
                "WHERE b.`taccount`=c.`taccount` AND b.`taccount`=?";
        ArrayList<Class> clss = new ArrayList<Class>();
        Connection conn = null;
        try {
            ResultSet rs = baseDAO.executeQry(sql,saccount);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clss;
    }

    // 根据课程编号得到所有的学生信息
    public ArrayList<Student> getAllStudents(String id) {
        String sql = "SELECT b.`saccount`,b.`name`,b.`password`,b.`phoneNumber`,b.`sex`\n" +
                "FROM apply AS a,student AS b\n" +
                "WHERE a.`saccount`=b.`saccount` AND a.`classId`=?";
        ArrayList<Student> students = new ArrayList<Student>();
        Connection conn = null;
        try {
            ResultSet rs = baseDAO.executeQry(sql,id);
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

    public ArrayList<Apply> getAllApply() {
        String sql = "SELECT * from apply";
        ArrayList<Apply> applys = new ArrayList<Apply>();
        Connection conn = null;
        try {
            //conn = ds.getConnection();
            //PreparedStatement pstmt = conn.prepareStatement(sql);
            //ResultSet rs = pstmt.executeQuery();
            ResultSet rs = baseDAO.executeQry(sql);
            while (rs.next()) {
                Apply apply = new Apply();
                apply.setStudentId(rs.getString(1));
                apply.setClassId(rs.getInt(2));
                apply.setId(rs.getInt(3));
                applys.add(apply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applys;
    }

    public boolean register(String studentId,int classId) {
        String sql = "insert into apply(saccount,classId) values(?,?)";
        Connection conn = null;
        try {
            //conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,studentId);
            pstmt.setInt(2,classId);
            int i=pstmt.executeUpdate();
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
