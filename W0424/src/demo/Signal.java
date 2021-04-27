package demo;

/**
 * @Author 王承尧
 * @Date 2021/4/24 9:59 下午
 */
public enum Signal {
    GREEN,
    YELLOW,
    RED;
}

class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    public String toString(){
        return "The traffic light is " + color;
    }

    public static void main(String[] args){
        TrafficLight t = new TrafficLight();
        for(int i=0; i<5; i++){
            System.out.println(t);
            t.change();
        }
    }

}

