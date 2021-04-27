package reflectTest1.test1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author 王承尧
 * @Date 2021/4/14 7:12 下午
 */
public class TestReflect {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        FileReader f = new FileReader("src/reflectTest1/test1/conf1.properties");
        Properties p = new Properties();

        p.load(f);

        f.close();

        Class c = Class.forName(p.getProperty("ClassName"));

        c.newInstance();

    }
}
