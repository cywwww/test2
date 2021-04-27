package test;

/**
 * @Author 王承尧
 * @Date 2021/4/24 9:37 下午
 */
public enum WeekDay {
    MONDAY("星期一",1),TUESDAY("星期二",2),WENSDAY("星期三",3),THURSDAY("星期四",4),FRIDAY("星期五",5);


    private String value;
    private int index;

    private WeekDay(String value, int index) {
        this.value = value;
        this.index = index;
    }




    public static void printWeekDay(String value){
        WeekDay[] ws = WeekDay.values();
        for(WeekDay w :ws ){
//            System.out.println(weekDay);
//            System.out.println(w);
            if (value.equals(w.value)){
                System.out.println("Today is " +w.value);
            }
        }
    }
    public static void printWeekDay(int index){
        WeekDay[] ws = WeekDay.values();
        for (WeekDay w:ws
             ) {
            if (index==w.index){
                System.out.println("Today is "+w.value);
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        WeekDay.printWeekDay("星期二");
        WeekDay.printWeekDay(1);
    }
}
