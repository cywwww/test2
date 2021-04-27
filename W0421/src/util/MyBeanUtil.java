package util;

import vo.User;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author 王承尧
 * @Date 2021/4/21 9:27 下午
 */
public class MyBeanUtil {

    /**
     * Map集合中的key保存的是参数的名字，value保存的是参数的值。
     * 利用反射将Map中的参数的值，复制到className中所指定的类对象中同名的属性中，并返回该对象。
     * @param params
     * @param className
     * @return
     */
    public static Object copyParamToBean(Map params, String className){
        Object o = null;
        try {
            Class clz = Class.forName(className);
            o = clz.newInstance();

            Field[] fs = clz.getDeclaredFields();
            for (int i=0;i<fs.length;i++){
                Iterator it = params.keySet().iterator();
                while(it.hasNext()){
                    String mName = (String) it.next();
                    String str = fs[i].getName();
                    if (mName.equals(str)) {
//                        System.out.println(str);
                        fs[i].setAccessible(true);
//                        System.out.println(params.get(mName));
                        fs[i].set(o,params.get(mName));
                    }

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return o;
    }

    public static void main(String[] args) {
        HashMap hmp = new HashMap();
        hmp.put("no",1);
        hmp.put("name","王");
        hmp.put("sex","男");
        hmp.put("age",18);

        User u = (User)copyParamToBean(hmp,"vo.User");
        System.out.println(u);
    }
}
