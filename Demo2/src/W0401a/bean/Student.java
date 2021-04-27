package W0401a.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/1 5:48 下午
 */
public class Student {
    private String stuId;
    private String stuName;
    private int stuAge;
    private String stuSex;
    private float stuScore;

    public Student() {
    }

    public Student(String stuId, String stuName, int stuAge, String stuSex, float stuScore) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuSex = stuSex;
        this.stuScore = stuScore;
    }


    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public float getStuScore() {
        return stuScore;
    }

    public void setStuScore(float stuScore) {
        this.stuScore = stuScore;
    }


    @Override
    public String toString() {
        return "Student{" +
                "stuId='" + stuId + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuSex='" + stuSex + '\'' +
                ", stuScore=" + stuScore +
                '}';
    }
}
