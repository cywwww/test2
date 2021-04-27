package test.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:39 下午
 */
public class Student {
    public int id;
    public String name;
    private String sex;

    public Student(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
