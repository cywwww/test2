package test;

import java.lang.reflect.Field;

/**
 * @Author 王承尧
 * @Date 2021/4/25 4:16 下午
 */
public class Test2 {

    public static void main(String[] args) {
        Integer o = new Integer(updateObject("12"));
        System.out.println(o);
    }


    public static <E> E updateObject(Object o){

        return (E) o;
    }
}
