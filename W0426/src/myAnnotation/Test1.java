package myAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author 王承尧
 * @Date 2021/4/26 4:47 下午
 */
@MyAnnotation1(value = "qwe",index = 1,values = {"1","s","asd"},color = MyEnum.BLUE)
public class Test1 {
    @MyAnnotation1(value = "s",index = 2,values = {"1","s","asd"},color = MyEnum.RED)
    private String name;

    @MyAnnotation1(value = "qwe",index = 1,values = {"1","s","asd"},color = MyEnum.BLUE)
    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                '}';
    }
}
class TestMain{
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class aClass = new Test1().getClass();

        MyAnnotation1 annotation1 = (MyAnnotation1) aClass.getAnnotation(MyAnnotation1.class);
        System.out.println("类注解信息:"+annotation1.value()+annotation1.color());

        Field name = aClass.getDeclaredField("name");
        MyAnnotation1 annotation = name.getAnnotation(MyAnnotation1.class);
        System.out.println("字段注解信息:"+annotation.value());

        Method toString = aClass.getDeclaredMethod("toString");
        MyAnnotation1 annotation2 = toString.getAnnotation(MyAnnotation1.class);
        System.out.println("方法注解信息："+annotation2.index());
    }
}
