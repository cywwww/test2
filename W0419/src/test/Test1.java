package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:15 下午
 */
public class Test1 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class stringClass = String.class;
        Constructor stringCon = stringClass.getConstructor();
        System.out.println("String无参构造器实例："+stringCon.newInstance());

        Constructor stringByte = stringClass.getConstructor(byte[].class);
        System.out.println("带参数String构造器"+stringByte.newInstance(new byte[]{'a', 's', 'd', 'z'}));

        Method[] ms =  stringClass.getDeclaredMethods();
        Iterator it = Arrays.stream(ms).iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
