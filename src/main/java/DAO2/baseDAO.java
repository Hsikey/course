package DAO2;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class baseDAO {
    DataSource dataSource;
    public baseDAO() {//连接数据源
        try{
            Context context=new InitialContext();
            dataSource=(DataSource)context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
            System.out.println("datasource出现错误"+e);
        }

    }
    //获得connection对象
    public Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }

    //增删改
    public int executeUpd(String sql,Object...arg) throws SQLException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        int count=0;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i <arg.length; i++) {
                pstmt.setObject(i + 1, arg[i]);
            }
            count = pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("增删改的时候出错"+e);
        }finally {
            if(conn!=null){
                conn.close();
          }
       // closeBoth( conn,  pstmt);
        }
        return count;

    }
    //返回结果集
    public  ResultSet executeQry(String sql,Object...arg) throws SQLException {
        ResultSet rs=null;
        Connection conn = null;
        PreparedStatement pstmt=null;

        try {
            conn = getConnection();
            pstmt=conn.prepareStatement(sql);
            for(int i=0;i<arg.length;i++){
                pstmt.setObject(i+1,arg[i]);
            }
            rs=pstmt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("查询时返回结果集出现异常"+e);
        }finally {
           if(conn!=null)
                conn.close();
            //closeAll(conn,  pstmt, rs);
        }
        return rs;
    }

    //登录时关闭
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //注册后关闭
    public static void closeBoth(Connection conn, PreparedStatement pstmt) throws SQLException {
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
