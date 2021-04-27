package W0401a.view;

import W0401a.bean.Student;
import W0401a.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/1 5:54 下午
 */
public class TestStudent {
    public static void main(String[] args) {
        System.out.println("***************学生管理系统 V1.0版*******************");
        System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
        Scanner sc = new Scanner(System.in);
        StudentDao sd = new StudentDao();
        while (true){
            System.out.print("请选择功能:");
            int in = sc.nextInt();

            switch(in){
                case 1:
                    System.out.println("请输入学员的信息：");
                    System.out.print("学号：");String stuId = sc.next();
                    System.out.print("姓名：");String stuName = sc.next();
                    System.out.print("年龄：");int stuAge = sc.nextInt();
                    System.out.print("性别：");String stuSex = sc.next();
                    System.out.print("成绩：");float stuScore = sc.nextFloat();
                    Student stu = new Student(stuId,stuName,stuAge,stuSex,stuScore);
                    if (sd.addStudent(stu)) {
                        System.out.println("添加成功");
                    }else{
                        System.out.println("添加失败");
                    }
                    System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
                    break;
                case 2:
                    System.out.print("请输入要删除学员的学号");String stuId2 = sc.next();
                    if (sd.deleteStudent(stuId2)) {
                        System.out.println("删除成功");
                    }else{
                        System.out.println("删除失败");
                    }
                    System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
                    break;
                case 3:
                    System.out.println("请输入要修改的学员信息：");
                    System.out.print("学号：");String stuId3 = sc.next();
                    System.out.print("姓名：");String stuName3 = sc.next();
                    System.out.print("年龄：");int stuAge3 = sc.nextInt();
                    System.out.print("性别：");String stuSex3 = sc.next();
                    System.out.print("成绩：");float stuScore3 = sc.nextFloat();
                    Student stu3 = new Student(stuId3,stuName3,stuAge3,stuSex3,stuScore3);
                    if (sd.setStudent(stu3)){
                        System.out.println("修改成功");
                    }else{
                        System.out.println("修改失败");
                    }
                    System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
                    break;
                case 4:
                    List<Student> l = sd.selectAll();
                    l.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("请输入学员学号：");String stuId5 = sc.next();
                    Student stu5 = sd.select(stuId5);
                    System.out.println(stu5);
                    System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("1.添加学员\t2.删除学院\t3.修改学员\t4.查找所有学员\t5.根据学号查找学员\t0.退出");
                    break;

            }

        }
    }
}
