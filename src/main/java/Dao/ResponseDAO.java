package Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ResponseDAO {
    DataSource ds = null;
    public ResponseDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
