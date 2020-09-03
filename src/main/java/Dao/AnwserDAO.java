package Dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AnwserDAO {
    DataSource ds = null;
    public AnwserDAO(){
        try {
            Context context=new InitialContext();
            ds = (DataSource) context.lookup("java:comp/env/jdbc/lb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

    }
}
