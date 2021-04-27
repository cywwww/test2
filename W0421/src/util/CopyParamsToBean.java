package util;

import com.sun.jdi.InvocationException;
import org.apache.commons.beanutils.PropertyUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

/**
 * @Author 王承尧
 * @Date 2021/4/21 7:51 下午
 */
public class CopyParamsToBean {
    public static Object copy(HttpServletRequest rs,String className){
        Object o = null;
        try{
            Class clz = null;
            clz = Class.forName(className);
            o = clz.newInstance();
            Enumeration<String> parameterNames = rs.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String typeName = parameterNames.nextElement();
                Field f = clz.getDeclaredField(typeName);
                Class<?> fName = f.getType();

                if (fName == int.class){
                    PropertyUtils.setProperty(o,typeName,Integer.parseInt(rs.getParameter(typeName)));
                }else if (fName == String.class){
                    PropertyUtils.setProperty(o,typeName,rs.getParameter(typeName));
                }

            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(InstantiationException e){
            e.printStackTrace();
        }catch(IllegalAccessException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch(InvocationTargetException e){
            e.printStackTrace();
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }

        return o;
    }
}
