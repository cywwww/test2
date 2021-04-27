package test;

import test.bean.Student;

import java.lang.reflect.Field;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:39 下午
 */
public class Test3 extends HttpServer{

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        setProperty(new Student(1,"张三","男"),"sex","女");
    }

    public static void setProperty(Object obj, String propertyName, Object propertyValue) throws NoSuchFieldException, IllegalAccessException {
        Class o = obj.getClass();
        Field f = o.getDeclaredField(propertyName);

        f.setAccessible(true);
        f.set(obj,propertyValue);
        System.out.println(obj);
    }

}
