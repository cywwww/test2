package W0402a.dao;

import W04006a.util.DBUtil;
import W0402a.inter.empDao;

import java.sql.*;

/**
 * @Author 王承尧
 * @Date 2021/4/5 10:07 下午
 */
public class empDaoImp implements empDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    CallableStatement cs = null;
    @Override
    public float selectSal(int deptNo) {
        conn = DBUtil.getConnection();
        try{
            String sql = "{call PRO_SELECTSUM (?,?)}";
            cs = conn.prepareCall(sql);
            cs.setInt(1,deptNo);
            cs.registerOutParameter(2,Types.FLOAT);
            cs.execute();
            return cs.getFloat(2);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

}
