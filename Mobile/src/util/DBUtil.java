package util;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/22 2:06 下午
 */
public class DBUtil {
    static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    static final String URL = "jdbc:oracle:thin:@localhost:1521:helowin";
    static final String USER = "scott";
    static final String PWD = "123456";

    static Connection conn = null;

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
