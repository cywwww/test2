package vo;

/**
 * @Author 王承尧
 * @Date 2021/4/21 7:53 下午
 */
public class User {
    private int no;
    private String name;
    private String sex;
    private int age;

    public User(int no, String name, String sex, int age) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User() {
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
