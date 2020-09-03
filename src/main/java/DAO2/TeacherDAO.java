package DAO2;

import bean.Teacher;
import bean.UserName;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAO {
    baseDAO baseDAO=new baseDAO();
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    int count=0;//影响表的行数

    public boolean AddTeacher(Teacher teacher) throws SQLException {
        String sql="select taccount from teacher where taccount=?";
        String sql1="insert into teacher(taccount,password,name,sex,phoneNumber) values(?,?,?,?,?)";
        ResultSet rs=null;
        try{
            rs=baseDAO.executeQry(sql,teacher.getAccount());
            if (rs.next()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (rs!=null){
                rs.close();
            }
        }
        try{
            int count=baseDAO.executeUpd(sql1,teacher.getPassword(),teacher.getName(),teacher.getSex(),teacher.getPhone(),teacher.getAccount());
            if(count>0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("添加学院信息失败！ " + e);
        }
        return false;
    }



    public Teacher onesearch(String no){
        String sql="select * from teacher where t_no=?";
        ResultSet rs=null;
        Teacher teacher=new Teacher();
        try {
            rs=baseDAO.executeQry(sql,no);
            if(rs.next()){
                teacher.setAccount(rs.getString("taccount"));
                teacher.setName(rs.getString("name"));
                teacher.setSex(rs.getString("sex"));
                teacher.setPhone(rs.getLong("phoneNumber"));
                teacher.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }

    //根据编号查找老师的名字
    public ArrayList TeacherNameQry(String sql, String t_no, UserName userName){
        ArrayList<UserName> list=new ArrayList<>();
        try{
            rs=baseDAO.executeQry(sql,t_no);
            while(rs.next()){
                UserName u=new UserName();
                u.setR_no(userName.getR_no());
                System.out.println("查找人名"+u.getR_no());
                u.setName(rs.getString("name"));
                list=list;
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
