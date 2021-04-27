package addressList.util;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/15 2:41 下午
 */
public class DBUtil {
    static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:helowin";
    static final String USER = "javaExam";
    static final String PWD = "123456";

   static Connection conn = null;
   static PreparedStatement ps = null;
   static CallableStatement cs = null;
   static ResultSet rs = null;

    static{
        try {
            Class.forName(DRIVER);//加载驱动包到程序
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

    public void closeAll(Connection conn,PreparedStatement ps,CallableStatement cs,ResultSet rs){
        try{
            if (rs == null) {
                rs.close();
            }
        }catch(SQLException e){e.printStackTrace();}try{
            if (cs == null) {
                cs.close();
            }
        }catch(SQLException e){e.printStackTrace();}try{
            if (ps == null) {
                ps.close();
            }
        }catch(SQLException e){e.printStackTrace();}try{
            if (conn == null) {
                conn.close();
            }
        }catch(SQLException e){e.printStackTrace();}
    }

}
