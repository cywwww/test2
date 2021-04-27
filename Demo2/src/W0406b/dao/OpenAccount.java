package W04006a.dao;

import W04006a.bean.CardInfo;
import W04006a.bean.UserInfo;
import W04006a.inter.Open;
import W04006a.util.DBUtil;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/6 7:51 下午
 */

public class OpenAccount implements Open {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    CallableStatement cs = null;

    /**
     * 开户功能
     * @param u
     * @param c
     * @return
     */
    @Override
    public boolean openAccount(UserInfo u, CardInfo c) {
        conn = DBUtil.getConnection();
        try {
            String sql = "{call pro_add1 (?,?,?,?,?,?,?)}";
            cs = conn.prepareCall(sql);

            cs.setString(1,u.getCustomerName());
            cs.setString(2,u.getPID());
            cs.setString(3,u.getTelephone());
            cs.setFloat(4,c.getOpenMoney());
            cs.setString(5,c.getSavingType());
            cs.setString(6,u.getAddress());
            cs.registerOutParameter(7,Types.VARCHAR);
            if (cs.executeUpdate()>0) {
                System.out.println("卡号"+cs.getString(7));
                System.out.println("开户成功");

                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DBUtil.closeAll(conn,ps,rs,cs);
        }

        return false;
    }
}
