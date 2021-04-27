package serializablepack.vo;

import java.io.Serializable;

/**
 * @Author 王承尧
 * @Date 2021/4/27 4:53 下午
 */
public class Pet implements Serializable {
    private String type;
    private int age;

    public Pet() {
    }

    public Pet(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
