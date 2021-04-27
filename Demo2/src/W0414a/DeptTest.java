package W0414a;

import W0414a.bean.Dept;
import W0414a.dao.DeptDao;

import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/14 3:26 下午
 */
public class DeptTest {
    public static void main(String[] args) {

         Scanner sc = new Scanner(System.in);
        System.out.println("功能菜单：");
        System.out.println("1、添加");
        System.out.println("2、根据部门名称查询");

        System.out.print("请选择序号：");int no = sc.nextInt();

        if (no==1)if (f1()) System.out.println("添加成功");
        if (no==2)f2();

    }

    public static boolean f1(){
        Scanner sc = new Scanner(System.in);
            System.out.print("部门名称：");String dName = sc.nextLine();
            System.out.print("经理名称：");String gName = sc.nextLine();
            System.out.print("描述信息：");String demo = sc.nextLine();

        return new DeptDao().addDept(new Dept(0,dName,gName,demo));
    }

    public static void f2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入部门名称：");String dName = sc.nextLine();

        System.out.println(new DeptDao().selectAll(dName));

    }
}
