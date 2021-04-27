package W04006a.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/6 7:27 下午
 */
public class CardInfo {
   private String cardID;//卡号
   private String curType;//货币种类
   private String savingType;//存款类型
   private String openDate;//开户日期
   private float openMoney ;//开户金额
   private float balance;//余额
   private int pass;//密码
   private String IsReportLoss;//是否挂失
   private int customerID;//顾客编

    public CardInfo(String cardID, String curType, String savingType, String openDate, float openMoney, float balance, int pass, String isReportLoss, int customerID) {
        this.cardID = cardID;
        this.curType = curType;
        this.savingType = savingType;
        this.openDate = openDate;
        this.openMoney = openMoney;
        this.balance = balance;
        this.pass = pass;
        IsReportLoss = isReportLoss;
        this.customerID = customerID;
    }

    public CardInfo() {
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public String getCurType() {
        return curType;
    }

    public void setCurType(String curType) {
        this.curType = curType;
    }

    public String getSavingType() {
        return savingType;
    }

    public void setSavingType(String savingType) {
        this.savingType = savingType;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public float getOpenMoney() {
        return openMoney;
    }

    public void setOpenMoney(float openMoney) {
        this.openMoney = openMoney;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getIsReportLoss() {
        return IsReportLoss;
    }

    public void setIsReportLoss(String isReportLoss) {
        IsReportLoss = isReportLoss;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "CardInfo{" +
                "cardID='" + cardID + '\'' +
                ", curType='" + curType + '\'' +
                ", savingType='" + savingType + '\'' +
                ", openDate='" + openDate + '\'' +
                ", openMoney=" + openMoney +
                ", balance=" + balance +
                ", pass=" + pass +
                ", IsReportLoss='" + IsReportLoss + '\'' +
                ", customerID=" + customerID +
                '}';
    }
}
