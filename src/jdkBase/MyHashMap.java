package jdkBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class MyHashMap  implements Runnable{





    public static void main(String[] args) {
        Random random = new Random();
        Integer[] integers = new Integer[20];
        for(int i =0;i<integers.length;i++){
            integers[i] = random.nextInt(100) * (random.nextBoolean() ? 1 : -1);
        }
        System.out.println("用系统内置方法:");
        Arrays.sort(integers);
        System.out.println(Arrays.asList(integers));

        System.out.println("other");
        Arrays.sort(integers, Comparator.comparingInt(Math::abs));
        System.out.println(Arrays.asList(integers));

        new MyHashMap().run();
    }

    @Override
    public void run() {
        System.out.println("haha");
    }
}