package W0402a;

import W0402a.dao.empDaoImp;

/**
 * @Author 王承尧
 * @Date 2021/4/5 10:25 下午
 */
public class Test {
    public static void main(String[] args) {
        empDaoImp e = new empDaoImp();
        float f = e.selectSal(10);
        System.out.println(f);
    }
}
