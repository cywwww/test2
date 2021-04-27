package W04006a.inter;

/**
 * @Author 王承尧
 * @Date 2021/4/6 10:44 下午
 */
public interface Select {
    public abstract boolean  enter(String cardId,int pwd);
//    public abstract String selectCardId();
    public abstract  float selectBalance(String cid,int pwd);
}
