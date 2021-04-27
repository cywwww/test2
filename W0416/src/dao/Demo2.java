package dao;

import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/16 4:45 下午
 */
public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入任意类的类名:");String className = sc.nextLine();
        Class c =  Class.forName(className);
        System.out.println(c.getName());


        Class c1 = c.getSuperclass();
        System.out.println(c1.getName());
        while((c1=c1.getSuperclass())!=null){
            System.out.println(c1.getName());
        }
    }
}
