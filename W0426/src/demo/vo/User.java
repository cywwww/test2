package demo.vo;

import demo.Column;
import demo.Table;

/**
 * @Author 王承尧
 * @Date 2021/4/26 6:15 下午
 */
@Table("user")
public class User {
    @Column("uid")
    private int uid;
    @Column("uname")
    private String uname;

    public User(int uid, String uname) {
        this.uid = uid;
        this.uname = uname;
    }

    public User() {

    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
