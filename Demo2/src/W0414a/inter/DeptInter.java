package W0414a.inter;

import W0414a.bean.Dept;

import java.util.ArrayList;

/**
 * @Author 王承尧
 * @Date 2021/4/14 3:33 下午
 */
public interface DeptInter {
    /**
     * 添加部门方法
     * @return
     */
    boolean addDept(Dept d);

    /**
     * 查询所有部门的方法
     * @return
     */
    Dept selectAll(String dName);
}
