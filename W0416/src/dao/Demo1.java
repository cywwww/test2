package dao;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王承尧
 * @Date 2021/4/16 4:37 下午
 */
public class Demo1 {
    public static void main(String[] args) {
        System.out.println("**************List相关信息******************");
        Class l = List.class;
        System.out.println("类名："+l.getName());
        System.out.println("包名:"+l.getPackage());
        System.out.println("是否为接口:"+l.isInterface());
        System.out.println("是否为数组："+l.isArray());
        System.out.println("获得其父类class对象:"+l.getSuperclass());
        System.out.println("**************List接口指向ArrayList相关信息******************");
        Class al = ArrayList.class;
        System.out.println("类名："+al.getName());
        System.out.println("包名:"+al.getPackage());
        System.out.println("是否为接口:"+al.isInterface());
        System.out.println("是否为数组："+al.isArray());
        System.out.println("获得其父类class对象:"+al.getSuperclass());
    }
}
