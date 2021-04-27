package test;

/**
 * @Author 王承尧
 * @Date 2021/4/24 9:12 下午
 */
public enum Test1 {
    MONDAY("星期一",1),TUESDAY("星期二",2),WENSDAY("星期三",3),THURSDAY("星期四",4),FRIDAY("星期五",5);


    private String value;
    private int index;

    private Test1(String value, int index) {
        this.value = value;
        this.index = index;
    }

    public static void get(){
        Test1[] ts = Test1.values();
        for (Test1 t : ts){
            System.out.println(t.value);
            System.out.println(t.index);
        }
    }
}

class Tt{
    public static void main(String[] args) {
        Test1.get();
    }
}
