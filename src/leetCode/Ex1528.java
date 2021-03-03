package leetCode;

public class Ex1528 {
    public String restoreString(String s, int[] indices) {
        var t = s.toCharArray();
        int i = 0;
        while (i < t.length) {
            if(indices[i]==i){
                i++;
            }else{
                int temp = indices[i];
                indices[i] = indices[indices[i]];
                indices[indices[i]] = temp;
                char tt = t[i];
                t[i] = t[indices[i]];
                t[indices[i]] = tt;
            }
        }
        return String.valueOf(t);
    }
}
