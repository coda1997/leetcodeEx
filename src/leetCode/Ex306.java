package leetCode;

public class Ex306{
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, num.length(), 0);
    }

    private boolean dfs(String num, long sum, int p, long pre, int len, int k){
        if(p==len){
            return k>2;
        }
        for (int i = p; i < len; i++) {
            var cur = helper(num, p, i);
            if(cur<0){
                continue;
            }
            if(k>=2&&sum!=cur){
                continue;
            }
            if(dfs(num, pre+cur, i+1, cur, len, k+1)){
                return true;
            }
        }
        return false;
    }

    private long helper(String num, int l, int r){
        if(l<r&&num.charAt(l)=='0'){
            return -1;
        }
        long temp = 0;
        while(l<=r){
            temp *= 10;
            temp += num.charAt(l)-'0';
            l++;
        }
        return temp;
    }
}