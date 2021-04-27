package serializablepack;

import serializablepack.vo.Student;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @Author 王承尧
 * @Date 2021/4/27 4:43 下午
 */
public class deserialization  {
        public static void main(String[]args) throws Exception{

            File f = new File("stu.bat");
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Student o = (Student) ois.readObject();
            System.out.println(o);

            ois.close();
        }
}
