package course;

import java.util.Random;

public class Shuffe {
    
    private int[] nums;
    private boolean[] table;
    
    public Shuffe(int[] nums) {
        this.nums = nums;
        table = new boolean[nums.length];
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        var temp = new int[nums.length];
        for(int i = 0;i<table.length;i++){
            table[i] = false;
        }//init
        var random = new Random();
        for(int i = 0;i<temp.length;i++){
            var t = random.nextInt(temp.length);
            if(table[t]){
                while(table[t]){
                    t = (t+1)%temp.length;
                }                
            }
            table[t] =true;
            temp[t]=nums[i];
        }
        return temp;
    }

}