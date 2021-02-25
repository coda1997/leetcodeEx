package leetCode;

import java.util.Arrays;

public class Ex853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int res = 0;
        if (position.length < 2) {
            return position.length;
        }
        var cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], (target - position[i]) * 1.0 / speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> o1.pos - o2.pos);
        for (int i = cars.length - 1; i >= 1; i--) {
            if (cars[i-1].time>cars[i].time){
                res++;
            }else{
                cars[i-1] = cars[i];
            }
        }
        return res + 1;
    }

    class Car {
        int pos;
        double time;

        Car(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        var o = new Ex853();
        System.out.println(o.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
        System.out.println(o.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(o.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3}));
    }
}
