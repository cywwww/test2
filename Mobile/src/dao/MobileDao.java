package dao;

import inter.MobileInter;
import util.DBUtil;
import vo.Mobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author 王承尧
 * @Date 2021/4/22 2:23 下午
 */
public class MobileDao implements MobileInter {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    @Override
    public boolean selectBrand(String brand) {
        conn = DBUtil.getConnection();
        try{
            String sql = "select brand from mobile where brand = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,brand);
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;//如果有数据说明已存在，返回false
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addMobile(Mobile m) {
        conn = DBUtil.getConnection();
        try{
            String sql = "insert into mobile values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,m.getBrand());
            ps.setString(2,m.getManufacturer());
            ps.setString(3, m.getProduce());
            if (ps.executeUpdate()>0) {
                return true;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
