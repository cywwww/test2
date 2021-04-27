package addressList.dao;

import addressList.bean.Linkman;
import addressList.inter.LinkManInter;
import addressList.util.DBUtil;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/15 2:56 下午
 */
public class LinkManDao implements LinkManInter {
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    @Override
    public boolean addLinkman(Linkman l) {
        conn = DBUtil.getConnection();
        try{
            String sql = "insert into linkman values(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,l.getName());
            ps.setString(2,l.getMoBle_phone());
            ps.setString(3,l.getPhone_num());
            ps.setString(4,l.getEmail());

            if (ps.executeUpdate()>0) {
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Linkman select(String name) {
        conn = DBUtil.getConnection();
        Linkman l = null;
        try{
            String sql = "select * from linkman where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();
            if (rs.next()){
                l = new Linkman(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
                return l;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
