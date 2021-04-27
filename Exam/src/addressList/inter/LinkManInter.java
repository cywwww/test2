package addressList.inter;

import addressList.bean.Linkman;

/**
 * @Author 王承尧
 * @Date 2021/4/15 2:53 下午
 */
public interface LinkManInter {

    /**
     * 添加方法
     * @return
     */
    boolean addLinkman(Linkman l);

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    Linkman select(String name);
}
