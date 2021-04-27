package W04006a.inter;

import W04006a.bean.CardInfo;
import W04006a.bean.UserInfo;

/**
 * @Author 王承尧
 * @Date 2021/4/6 7:47 下午
 */
public interface Open{
    /**
     * 开户信息
     * @param u
     * @param c
     * @return
     */
    public abstract boolean openAccount(UserInfo u, CardInfo c);

}
