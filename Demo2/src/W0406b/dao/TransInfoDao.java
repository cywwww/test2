package W04006a.dao;

import W04006a.bean.TransInfo;
import W04006a.inter.Trans;
import W04006a.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/7 8:08 下午
 */
public class TransInfoDao implements Trans {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;


    @Override
    public ArrayList<TransInfo> selctTrans(String cId) {
        conn = DBUtil.getConnection();
        ArrayList<TransInfo> a = new ArrayList<>();
        try{
            String sql = "select * from transInfo where cardId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cId);
            rs = ps.executeQuery();
            while (rs.next()){
                a.add(new TransInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getString(5)));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return a;
    }
}
