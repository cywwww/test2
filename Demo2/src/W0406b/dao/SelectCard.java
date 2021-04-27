package W04006a.dao;

import W04006a.util.DBUtil;
import W04006a.inter.Select;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/6 10:44 下午
 */
public class SelectCard implements Select {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;

    @Override
    public boolean enter(String cardId, int pwd) {
        conn = DBUtil.getConnection();
        try{
            String sql = "select count(*) from cardInfo where  cardID = ? and pass = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cardId);
            ps.setInt(2,pwd);

            rs = ps.executeQuery();
            if (rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs,cs);
        }
        return false;
    }

    @Override
    public float selectBalance(String cid, int pwd) {
        conn =DBUtil.getConnection();
        try{
            String sql = "select balance from cardInfo where cardid = ? and pass = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cid);
            ps.setInt(2,pwd);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getFloat(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs,cs);
        }
        return -1;
    }
}
