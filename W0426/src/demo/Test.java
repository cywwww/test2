package demo;

import demo.vo.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 王承尧
 * @Date 2021/4/26 6:17 下午
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User u= new UserDao().select(assembleSqlFromObj(new User(1,"张三")));//对象返回null即为未找到
//        User u = new UserDao().select("select * from user");
        System.out.println(u);
    }

    public static String assembleSqlFromObj(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clz = obj.getClass();
        StringBuilder sb = new StringBuilder("select * from ");
        Table t = (Table) clz.getAnnotation(Table.class);
        String tableName = t.value();
        sb.append(tableName+" where 1 = 1 ");
        Field[] fs = clz.getDeclaredFields();
        for(Field f : fs){
            String fName = f.getName();
            String methodName = "get"+(fName.substring(0,1).toUpperCase())+fName.substring(1);
//            System.out.println(methodName);
            Column column = f.getAnnotation(Column.class);
            if (column!=null){
                Method method;
                method = clz.getMethod(methodName);
                Object value = method.invoke(obj);
                sb.append("and "+column.value()+" = '" + value +"' ");
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
