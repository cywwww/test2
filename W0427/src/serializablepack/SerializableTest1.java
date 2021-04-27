package serializablepack;

import serializablepack.vo.Pet;
import serializablepack.vo.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @Author 王承尧
 * @Date 2021/4/27 4:35 下午
 */
public class SerializableTest1 {
    public static void main(String[] args) throws Exception {
        //将一个学员对象序列化到stu.bat文件中
        File f = new File("stu.bat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream obs = new ObjectOutputStream(fos);

        Student s = new Student("一叶之秋",18,"123",99f,new Pet("柴犬",2));
        obs.writeObject(s);

        obs.flush();

        obs.close();
    }
}
