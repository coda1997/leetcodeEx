package review;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if(maxHeap.peek()>num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        while (minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size()-minHeap.size()>1){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size()==maxHeap.size()){
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }else{
            return maxHeap.peek();
        }
    }
}
