
package addressList;

import addressList.bean.Linkman;
import addressList.dao.LinkManDao;

import java.util.Scanner;

/**
 * @Author 王承尧
 * @Date 2021/4/15 3:01 下午
 */
public class LinkmanTest {
    public static void main(String[] args) {Scanner sc = new Scanner(System.in);
        System.out.println("功能菜单：\n1、添加\n2、根据姓名查询");
        System.out.print("请选择序号:");int no = sc.nextInt();
        if(no==1){f1();}
        if(no==2)f2();
    }
    public static void f1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("姓名：");String name = sc.nextLine();
        System.out.print("移动电话：");String phone = sc.nextLine();
        System.out.print("固定电话：");String phone_n = sc.nextLine();
        System.out.print("电子邮件：");String email = sc.nextLine();
        if (new LinkManDao().addLinkman(new Linkman(name,phone,phone_n,email))) {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public static void f2(){
        Scanner sc = new Scanner(System.in);
        System.out.print("查询姓名：");String name = sc.nextLine();
        Linkman l = new LinkManDao().select(name);
        System.out.println(l);
    }
}

