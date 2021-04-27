package W0414a.dao;

import W0414a.bean.Dept;
import W0414a.inter.DeptInter;
import W0414a.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/14 3:35 下午
 */
public class DeptDao implements DeptInter {

    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    /**
     * 添加部门方法
     * @param d
     * @return
     */
    @Override
    public boolean addDept(Dept d) {
        /**
         * @author: 王承尧
         * @description: TODO
         * @date: 2021/4/14 3:52 下午
         * @param d
         * @return boolean
         */
        conn = DBUtil.getConnection();
        try{
            String sql = "insert into dept values(dept0414Sq.nextval,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,d.getDname());
            ps.setString(2,d.getManager());
            ps.setString(3,d.getDemo());

            if (ps.executeUpdate()>0) {
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Dept selectAll(String dName) {
        Dept d = null;
        conn = DBUtil.getConnection();
        try {
            String sql = "select * from dept where dName = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,dName);
            rs = ps.executeQuery();
            if (rs.next()){
                d = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
                return d;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
