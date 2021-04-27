package W04006a.dao;

import W04006a.inter.CardDaoInterface;
import W04006a.util.DBUtil;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/6 11:13 下午
 */
public class CardDao implements CardDaoInterface {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;

    @Override
    public boolean addMoney(String cId,String type,int pass, float money) {
        conn = DBUtil.getConnection();
        try{
            conn.setAutoCommit(false);
            String sql = "{call proc_takeMoney (?,?,?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1,cId);
            cs.setString(2,type);
            cs.setInt(3,pass);
            cs.setFloat(4,money);
            cs.registerOutParameter(5,Types.VARCHAR);
            cs.executeUpdate();
            return true;
        }catch(SQLException e ){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs,cs);
        }
        return false;
    }


    @Override
    public boolean updateCard(String cid,int pwd) {
        conn = DBUtil.getConnection();
        try{
            String sql = "update CardInfo set pass = pwd where cardId = ? and pass = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,cid);
            ps.setInt(2,pwd);
            if (ps.executeUpdate()>0) {
                return true;
            }
        }catch(SQLException e ){
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(conn,ps,rs,cs);
        }
        System.out.println("修改失败");
        return false;
    }

    @Override
    public boolean transferAccounts(String cId,int pwd,String mId,float tMoney) {
        conn = DBUtil.getConnection();
        try{
            String sql = "{call proc_transfer (?,?,?,?,?)}";
            cs = conn.prepareCall(sql);
            cs.setString(1,cId);
            cs.setInt(2,pwd);
            cs.setString(3,mId);
            cs.setFloat(4,tMoney);
            cs.registerOutParameter(5,Types.VARCHAR);
            if (cs.executeUpdate()>0) {
//                System.out.println(cs.getFloat(5));
                System.out.println("转账成功");
                return true;
            }
            System.out.println(cs.getString(4));
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("转账失败");
        return false;
    }
}
