package test;

import java.util.*;

/**
 * @Author 王承尧
 * @Date 2021/4/25 3:57 下午
 */
public class HashMapStudent<T>{
    public  T min;
    public  T max;

    public HashMapStudent(Student min, Student max) {
        this.min = (T) min;
        this.max = (T) max;
    }

    public T getMin() {
        return min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public static void main(String[] args) {
        HashMap<String,Float> hs = new HashMap<>();

        hs.put("一叶之秋",99f);
        hs.put("一枪穿云",97f);
        hs.put("逢山鬼泣",88f);
        hs.put("王不留行",95f);
        hs.put("沐雨橙风",100f);

//        System.out.println(avg(hs));
//        sor
        HashMapStudent<Student> h = sort(hs);
        System.out.println("最低分" + h.getMin().getName() + ":" + h.getMin().getScore());
        System.out.println("最高分" + h.getMax().getName() + ":" + h.getMax().getScore());
    }


    public static float avg(HashMap<String,Float> hs){
        Iterator<String> it = hs.keySet().iterator();
        float sum = 0;
        while(it.hasNext()){
            String key = it.next();
            sum+=hs.get(key);
        }
        return sum/hs.size();
    }

    public static <E> HashMapStudent<E> sort(HashMap<String,Float> hs){
        if (hs == null&&hs.size()==0) {
            return null;
        }
        Student min = null;
        Student max = null;
        for (Map.Entry<String,Float> h : hs.entrySet()){
            Student temp = new Student(h.getKey(),h.getValue());
                if (min==null&&max==null){
                        min = temp;
                        max = temp;
                }

                if (min.compareTo(temp)>0){
                    min = temp;
                }
                if (max.compareTo(temp)<0){
                    max = temp;
                }

                System.out.println(h.getKey()+":"+h.getValue());

        }
        System.out.println(min.getName()+":"+min.getScore());

        return new HashMapStudent(min,max);
    }


}
