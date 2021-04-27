package test;

/**
 * @Author 王承尧
 * @Date 2021/4/25 7:44 下午
 */
public class Student implements Comparable{
    private String name;
    private float score;

    public Student(String name, float score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.score>s.getScore()?1:(this.score==s.getScore()?0:-1);
    }
}
