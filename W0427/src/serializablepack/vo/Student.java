package serializablepack.vo;

import java.io.Serializable;

/**
 * @Author 王承尧
 * @Date 2021/4/27 4:35 下午
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private transient String password;
    private float score;
    private Pet pet;

    public Student() {
    }

    public Student(String name, int age, String password, float score,Pet pet) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.score = score;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", score=" + score +
                ", pet=" + pet +
                '}';
    }
}
