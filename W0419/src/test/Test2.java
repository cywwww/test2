package test;

import test.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:27 下午
 */
public class Test2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        System.out.println(getPropertyValue(new User(123), "id"));

    }

    /**
     *
     * @param obj
     * @param propertyName
     * @return
     */
    public static Object getPropertyValue(Object obj, String propertyName) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class o = obj.getClass();
        Field f = o.getDeclaredField("id");

        return f.getInt(obj);
    }

}
