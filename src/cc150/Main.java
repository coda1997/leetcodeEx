package cc150;

import java.util.Scanner;

import java.util.Scanner;
public class Main {
//    public static void main(String[] args) {
////        Scanner in = new Scanner(System.in);
////        long k = in.nextLong();
////        long l1 = in.nextLong();
////        long num1 = in.nextLong();
////        long l2 = in.nextLong();
////        long num2 = in.nextLong();
////
////        if (l1*num1+l2*num2<k){
////            System.out.println(0);
////            return;
////        }
////        long t = 0L;
////        long res = 0L;
////        while (t*l1<=k){
////            long t2 = k-l1*t;
////            if (t2%l2!=0){
////                t++;
////                continue;
////            }else {
////                res+=getNum(num1,t)*getNum(num2,t2/l2);
////                t++;
////            }
////
////        }
////        System.out.println(res%1000000007);
////    }
////    static long getNum(long k, long i){
////        if (i==0) return 1L;
////        long res = 1L;
////        while (i>0){
////            res *=k--/i--;
////        }
////        return res;
////    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int machineNum = in.nextInt();
        int taskNum = in.nextInt();
        if (machineNum==0||taskNum==0){
            System.out.println(0+" "+0);
            return;
        }
        int[][] M = new int[machineNum][2];
        int[][] T = new int[taskNum][2];
        for (int i =0;i<machineNum;i++){
            M[i][0] = in.nextInt();
            M[i][1] = in.nextInt();
        }
        for (int i = 0;i<taskNum;i++){
            T[i][0]= in.nextInt();
            T[i][1] = in.nextInt();
        }
        int[][] cost =new int[machineNum][taskNum];
        int[] maxPro = new int[machineNum];
        for (int i =0;i<cost.length;i++){
            int t = 0;
            for (int j = 0;j<cost[i].length;j++){
                if (M[i][0]>=T[j][0]&&M[i][1]>=T[j][1]){
                    cost[i][j] = 200*T[j][0]+3*T[j][1];
                    t = cost[i][j]>t? cost[i][j]:t;
                }
            }
            maxPro[i]=t;
        }
        boolean[] usedM = new boolean[machineNum];
        boolean[] usedT = new boolean[taskNum];
        int num = 0;
        int profit = 0;
        while (true){
            int t = findMax(cost);
            if (t==0){
                break;
            }
            profit+=t;
            num++;
        }
        System.out.println(num+" "+profit);

    }
    static int findMax(int[][] cost){
        int max = 0;
        int ti = 0,tj=0;
        for (int i = 0;i<cost.length;i++){
            for (int j = 0;j<cost[i].length;j++){
                if (max<cost[i][j]){
                    max=cost[i][j];
                    ti=i;
                    tj=j;
                }

            }

        }
        if (max==0) return 0;
        for (int i = 0;i<cost.length;i++){
            cost[i][tj]=0;
        }
        for (int i = 0;i<cost[ti].length;i++){
            cost[ti][i]=0;
        }
        return max;
    }
}
