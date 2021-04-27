package W0414a.bean;

/**
 * @Author 王承尧
 * @Date 2021/4/14 3:29 下午
 */
public class Dept {
    private int deptno;
    private String dname;
    private String manager;
    private String demo;

    public Dept(int deptno, String dname, String manager, String demo) {
        this.deptno = deptno;
        this.dname = dname;
        this.manager = manager;
        this.demo = demo;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }

    @Override
    public String toString() {
        return "「" +
                "\n部门编号=" + deptno +
                ",\n 部门名称=" + dname +
                ",\n部门经理=" + manager +
                ",\n描述信息=" + demo  +
                "\n」";
    }
}
