package Dao;

import bean.Class;
import bean.Discuss;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscussDAO {
    DataSource ds = null;
    public DiscussDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Discuss> executeQry(String sql, int classId){
        ArrayList<Discuss> list = new ArrayList<Discuss>();
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
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

        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
}
