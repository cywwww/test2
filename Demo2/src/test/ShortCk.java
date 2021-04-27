package test;

/**
 * @Author 王承尧
 * @Date 2021/4/9 4:27 下午
 */
public class ShortCk {
    public static void main(String args[]) {
        int counter = 0;
        boolean t = true;
        boolean f = false;
        boolean b = false;
        b = (t && ((counter++) == 0));
        b = (f && ((counter += 2) > 0));
        System.out.println(counter);
    }
}

