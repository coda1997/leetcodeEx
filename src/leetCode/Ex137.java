package leetCode;

import java.util.ArrayList;

public class Ex137 {
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += getBitNumber(num, i);
            }
        }
        int res = 0;
        int set = 1;
        for (int i = 0; i < 32; i++) {
            if (bits[i]%3!=0){
                res +=set;
            }
            set*=2;
        }

        return res;
    }

    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp^=num;
        }
        int flag = -1;
        for (int i = 0; i < 32; i++) {
            if (getBitNumber(temp,i)==1){
                flag=i;
            }
        }
        ArrayList<Integer> t1 = new ArrayList<>();
        ArrayList<Integer> t2 = new ArrayList<>();
        for (int num : nums) {
            if (getBitNumber(num,flag)==1){
                t1.add(num);
            }else {
                t2.add(num);
            }
        }
        return new int[]{getDuplicate(t1),getDuplicate(t2)};
    }

    private int getBitNumber(int num, int bit) {
        num = num >> bit;
        return num & 1;
    }

    private int getDuplicate(ArrayList<Integer> nums){
        int res=0;
        for (Integer num : nums) {
            res ^= num;
        }
        return res;
    }
}
