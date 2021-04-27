package addressList.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/15 2:49 下午
 */
public class Linkman {
    private String name;
    private String moBle_phone;
    private String phone_num;
    private String email;

    public Linkman(String name, String moBle_phone, String phone_num, String email) {
        this.name = name;
        this.moBle_phone = moBle_phone;
        this.phone_num = phone_num;
        this.email = email;
    }

    public Linkman() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoBle_phone() {
        return moBle_phone;
    }

    public void setMoBle_phone(String moBle_phone) {
        this.moBle_phone = moBle_phone;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "{\n" +
                "名字=" + name +
                ", 移动电话='" + moBle_phone +
                ", 固定电话='" + phone_num +
                ", 邮箱='" + email +
                "\n}";
    }
}
