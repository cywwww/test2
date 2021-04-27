package W04006a.inter;

import W04006a.bean.TransInfo;

import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/7 8:07 下午
 */
public interface Trans {

    ArrayList<TransInfo> selctTrans(String cId);
}
