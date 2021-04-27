package inter;

import vo.Mobile;


/**
 * @Author 王承尧
 * @Date 2021/4/22 2:20 下午
 */
public interface MobileInter {

    /**
     * 用于主键指定查询
     * @return
     */
    boolean selectBrand(String brand);

    /**
     * 添加
     * @param m
     * @return
     */
    boolean addMobile(Mobile m);
}
