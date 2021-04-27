package demo;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:46 下午
 */
public class User {
    private int id;
    private String name;
    private String sex;
    private String address;

    public User(int id, String name, String sex, String address) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
