package W04006a.inter;

/**
 * @Author 王承尧
 * @Date 2021/4/6 11:13 下午
 */
public interface CardDaoInterface {

    /**
     * 存钱
     * @return
     */
    public abstract boolean addMoney(String cId,String type,int pass,float money);

    public abstract boolean transferAccounts(String cId,int pwd,String mId,float tMoney);

    public abstract boolean updateCard(String cId,int pwd);
}
