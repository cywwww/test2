package demo;

import java.lang.reflect.Field;

/**
 * @Author 王承尧
 * @Date 2021/4/19 4:45 下午
 */
public class Demo1 {
    public static void main(String[] args) throws IllegalAccessException {
        updateMemberOfString(new User(1,"ad","ss","dada"));
    }

    /**
     *将任意一个对象中的所有String类型的成员变量所对应的字符串内容中的"a"改为"b"
     * @param obj
     */
    public static void updateMemberOfString(Object obj) throws IllegalAccessException {
        Class o = obj.getClass();
        Field[] fs = o.getDeclaredFields();
        String str = "";
        for (Field f : fs) {
            if (f.getType().getSimpleName().equals("String")) {
                f.setAccessible(true);
                System.out.println("oldString:"+f.get(obj));
                str = (String) f.get(obj);
                str =  str.replace('a','b');
                f.set(obj,str);
                System.out.println("newString:"+f.get(obj));
            }
        }
        System.out.println(obj);
    }
}
