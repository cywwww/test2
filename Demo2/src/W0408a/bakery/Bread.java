package W0408a.bakery;

/**
 * @Author 王承尧
 * @Date 2021/4/8 8:27 下午
 */
public class Bread {
    //无辜的面包
    private int id;

    public Bread(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "id=" + id +
                '}';
    }
}
