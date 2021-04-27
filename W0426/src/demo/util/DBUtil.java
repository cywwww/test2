package demo.util;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/26 6:39 下午
 */
public class DBUtil {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://127.0.0.1:3306/testdba";
    static final String USER = "root";
    static final String PWD = "12345678";

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){

        try {
            conn  = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
