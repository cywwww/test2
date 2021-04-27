package W0414a.util;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/14 3:35 下午
 */
public class DBUtil {
    public final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:helowin";
    public final static String USER = "dept0414";
    public final static String PWD = "123456";

    static Connection conn = null;
    static PreparedStatement ps =null;
    CallableStatement cs = null;
    ResultSet rs = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn,PreparedStatement ps,CallableStatement cs,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (cs != null) {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
