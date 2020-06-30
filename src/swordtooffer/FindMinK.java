package swordtooffer;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMinK {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[k];
        }
        //最大堆可以做到O（NlogK）的时间复杂度
        Queue<Integer> heap = new PriorityQueue<>((v1,v2)->v2-v1);
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(heap.peek()>arr[i]){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        int i =0;
        for (Integer integer : heap) {
            res[i++] = integer;
        }
        return res;
    }
    
}