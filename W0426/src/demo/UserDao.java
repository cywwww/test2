package demo;

import demo.util.DBUtil;
import demo.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author 王承尧
 * @Date 2021/4/26 6:56 下午
 */
public class UserDao {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    public  User select(String sql){
        User u = null;
        conn = DBUtil.getConnection();
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                u = new User(rs.getInt(1),rs.getString(2));
                return u;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}
