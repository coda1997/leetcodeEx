package course;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        var res = new ArrayList<String>();
        int start =0, end=0;
        boolean isStart = false, isEnd = false;
        for (int i = 0; i < nums.length; i++) {
            var item = nums[i];
            if(!isStart){
                start = item;
                isStart = true;
                continue;
            }
            if(!isEnd){
                if(item-1==start){
                    end = item;
                    isEnd = true;
                }else{
                    res.add(start+"");
                    start = item;
                    isStart = true;
                }
                continue;
            }
            // start and end are not -1
            if(item-1==end){
                end = item;
                isEnd = true;
                // isEnd = true;
                continue;
            }else{
                // item-1 != end
                // instert current string to res, and restart the loop
                res.add(start+"->"+end);
                start = item;
                end = 0;
                isEnd = false;
            }
        }
        if(isEnd){
            res.add(start+"->"+end);
            isStart=false;
        }
        if(isStart){
            res.add(start+"");
        }
        return res;
    }
    public static void main(String[] args) {
        var o = new SummaryRange();
        var res = o.summaryRanges(new int[]{-2147483648,-2147483647,2147483647});
        for (String s : res) {
            System.out.println(s);
        }
    }
}