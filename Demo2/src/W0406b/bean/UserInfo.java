package W04006a.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/6 7:27 下午
 */
public class UserInfo {
    private int customerID;//顾客编号
    private String customerName;//开户名
    private String PID;//身份证号
    private String telephone;//联系电话
    private String address;//居住地

    public UserInfo() {
    }

    public UserInfo(int customerID, String customerName, String PID, String telephone, String address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.PID = PID;
        this.telephone = telephone;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", PID=" + PID +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
