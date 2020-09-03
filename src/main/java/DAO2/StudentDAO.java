package DAO2;

import bean.*;
import bean.Class;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {
    DAO2.baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    int count=0;//影响表的行数

    //根据学生的学号查找全部信息
    public ArrayList StudentMessage(String sql, String s_no) throws SQLException {
        ArrayList<Student> list=new ArrayList<>();
        try{
            rs=baseDAO.executeQry(sql,s_no);
            while(rs.next()){
                Student s=new Student();
                s.setAccount(rs.getString("saccount"));
                s.setName(rs.getString("name"));
                s.setSex(rs.getString("sex"));
                s.setPhone(rs.getLong("phoneNumber"));
                s.setPassword(rs.getString("password"));
                list=list;
                list.add(s);
            }
            // System.out.println("查询学院时出现错误");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询学生时出现错误");
        }finally {
            if(rs!=null)
                rs.close();
            // closeRs(rs);
        }

        return  list;
    }
    public Student StudentMessage(String s_no) throws SQLException {
        String sql="select * from student where s_no=?";
        Student s=new Student();
        try{
            rs=baseDAO.executeQry(sql,s_no);
            while(rs.next()){
                s.setAccount(rs.getString("saccount"));
                s.setName(rs.getString("name"));
                s.setSex(rs.getString("sex"));
                s.setPhone(rs.getLong("phoneNumber"));
                s.setPassword(rs.getString("password"));
            }
            // System.out.println("查询学院时出现错误");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询学生时出现错误");
        }finally {
            if(rs!=null)
                rs.close();
            // closeRs(rs);
        }

        return  s;
    }
    //根据学号查找学生的名字 ，将改学生的名字以及回复的id 存储起来一一对应
    public ArrayList StudentName(String sql, String s_no, UserName userName) throws SQLException {
        ArrayList<UserName> list=new ArrayList<>();
        try{
            rs=baseDAO.executeQry(sql,s_no);
            while(rs.next()){
                UserName u=new UserName();
                u.setR_no(userName.getR_no());
                u.setName(rs.getString("s_username"));
                list=list;
                list.add(u);
            }
            // System.out.println("查询学院时出现错误");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查询学生时出现错误");
        }finally {
            if(rs!=null)
                rs.close();
            // closeRs(rs);
        }

        return  list;
    }
    /*  baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    int count=0;//影响表的行数
*/
    //学生注册
    public int studentRegister(Student student){
        String sql="insert into student(s_no,s_username,s_password,s_phone,s_grade,a_no,s_mail) values(?,?,?,?,?,?,?)";
        try{
            count=baseDAO.executeUpd(sql,student.getAccount() ,student.getName(),student.getPassword(),student.getPhone(),student.getSex());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("学生注册时出现错误");
        }
        return count;
    }
    //选课
    public int ChoiceCourse(String sql,String c_no,String s_no,String t_no)  {
        try {
            count = baseDAO.executeUpd(sql, c_no, s_no, t_no);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("学生选课时出现错误"+e);
        }
        return count;
    }

    //修改密码
    public int AlterPassword(String sql,String newPassword,String s_no,String phone) throws SQLException {
        count=baseDAO.executeUpd(sql,newPassword,s_no,phone);
        return count;
    }

    //查找学生的课程
    public ArrayList StuCourse(String sql,String saccount){
        ArrayList<Class> list=new ArrayList<>();
        try{
            rs=baseDAO.executeQry(sql,saccount);
            while (rs.next()){
                Class sc=new Class();
                sc.setName(rs.getString("name"));
                System.out.println(sc.getName());
                sc.setId(rs.getInt("classId"));
                sc.setTeacher(rs.getString("taccount"));
                sc.setStartDate(rs.getDate("startDate"));
                sc.setEndDate(rs.getDate("endDate"));
                sc.setStudentSum(rs.getInt("studentSum"));
                sc.setStudentId(rs.getInt("studentId"));
                sc.setNotificationId(rs.getInt("notificationId"));
                sc.setSignId(rs.getInt("signId"));
                sc.setDiscussId(rs.getInt("discussId"));
                sc.setTaskId(rs.getInt("taskId"));
                list=list;
                list.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("查找课程错误");
        }
        return list;
    }




}
