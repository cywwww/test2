package W04006a.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/6 7:27 下午
 */
public class TransInfo {
private String transDate;//交易日期
private String cardID;//卡号
private String transType;//交易类型
private float transMoney;//交易金额
private String remar;//备

    public TransInfo(String transDate, String cardID, String transType, float transMoney, String remar) {
        this.transDate = transDate;
        this.cardID = cardID;
        this.transType = transType;
        this.transMoney = transMoney;
        this.remar = remar;
    }

    public TransInfo() {
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public float getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(float transMoney) {
        this.transMoney = transMoney;
    }

    public String getRemar() {
        return remar;
    }

    public void setRemar(String remar) {
        this.remar = remar;
    }

    @Override
    public String toString() {
        return "TransInfo{" +
                "transDate='" + transDate + '\'' +
                ", cardID='" + cardID + '\'' +
                ", transType='" + transType + '\'' +
                ", transMoney=" + transMoney +
                ", remar='" + remar + '\'' +
                '}';
    }
}
