package reflectTest1.test2;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @Author 王承尧
 * @Date 2021/4/15 7:01 下午
 */
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class o = Class.forName("reflectTest1.test2.User");
        Object obj = o.newInstance();

        Field[] fs = o.getDeclaredFields();
        System.out.println(fs[1].getName());
        System.out.println(fs[1].getType());
        System.out.println(Modifier.toString(fs[1].getModifiers()));

        Field f = o.getDeclaredField("sex");

        /**
         * 让外部也有访问私有成员的机会
         * 打破封装（反射机制的缺点：打破封装，可能会给不法分子留下机会！！！）
         */
        f.setAccessible(true);

        f.set(obj,false);
        System.out.println(f.get(obj));
//        fs[1].set(obj,false);
        Object ob = new User().getClass();


    }
}
