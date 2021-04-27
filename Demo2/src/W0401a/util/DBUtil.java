package W0401a.util;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/1 4:40 下午
 */
public class DBUtil {
    static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@localhost:1521:helowin";
    static final String USER = "scott";
    static final String PWD = "123456";

    static Connection conn =null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回连接对象
     * @return
     */
    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps!=null){
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
