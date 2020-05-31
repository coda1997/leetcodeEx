package course;

import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        var res = new LinkedList<String>();
        for (int i = 1; i <= n; i++) {
            if(i%3==0){
                if(i%5==0){
                    res.add("FizzBuzz");
                }else{
                    res.add("Fizz");
                }
            }else if(i%5==0){
                res.add("Buzz");
            }else{
                res.add(String.valueOf(i));
            }
        }
        return res;
    } 
}