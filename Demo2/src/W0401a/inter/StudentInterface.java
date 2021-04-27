package W0401a.inter;

import W0401a.bean.Student;

import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/1 6:01 下午
 */
public interface StudentInterface {
    /**
     *
     * @param stu
     * @return
     */
    public boolean addStudent(Student stu);

    /**
     * 根据学号删除学员
     * @param stuId
     * @return
     */
    public boolean deleteStudent(String stuId);

    /**
     * 修改学员信息
     * @param stu
     * @return
     */
    public boolean setStudent(Student stu);

    /**
     * 查找所有学员信息
     * @return
     */
    public ArrayList<Student> selectAll();

    /**
     * 根据学号查找指定学员信息
     * @param stuId
     * @return
     */
    public Student select(String stuId);

}
