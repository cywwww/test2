package util;

import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王承尧
 * @Date 2021/4/23 12:28 上午
 */
public class JdbcTemplate {

    /**
     * 利用反射，将所有查询的结果集中的值，绑定到cls所指定的Bean对象中，并将Bean对象保存到集合中返回
     * @param sql
     * @param values
     * @param cls
     * @return
     */
    public List query(String sql, Object[] values, Class cls){
        List<User> l= new ArrayList<>();
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
//            cls.new//
            while (rs.next()){

            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }

        return l;
    }
}
