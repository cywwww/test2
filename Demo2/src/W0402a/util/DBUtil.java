package W0402a.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author 王承尧
 * @Date 2021/4/5 9:46 下午
 */
public class DBUtil{
    static Properties pr = new Properties();
    static FileReader fr;

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;


    static {
        try {
            fr = new FileReader("../Demo2/src/W0402a/conf.properties");
            pr.load(fr);
            Class.forName(pr.getProperty("DRIVER"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        try {
            conn = DriverManager.getConnection(pr.getProperty("URL"), pr.getProperty("USER"), pr.getProperty("PWD"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
