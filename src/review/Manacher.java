package review;

public class Manacher {
    /*
    * manacher
    * 1st, insert # to make the s has the odd length
    * traversal from head to tail
    * in traversal, we use a array to record the maximum length of arm in i-index;
    *
    * */
    public String longestPalindrome(String s) {
        //insert # into s
        char[] temp = new char[s.length()*2+1];
        for (int i = 0; i < s.length(); i++) {
            temp[2*i] = '#';
            temp[2 * i + 1] = s.charAt(i);
        }
        temp[temp.length-1] = '#';
        int start = 0, end = -1;
        int[] lens = new int[temp.length];
        int right = -1, j = -1;
        for (int i = 0; i < temp.length; i++) {
            int armLen;
//            if (right > i) {
//                int iSym = 2*j-i;
//                int minArmLen = Math.min(lens[iSym], right-i);
//                armLen = expand(temp, i-minArmLen, i+minArmLen);
//            }else{
//                armLen = expand(temp, i, i);
//            }
//            lens[i] =armLen;
            if(right>i){
                int iSym = 2*j-i;
                int lMin = Math.min(right-i, lens[iSym]);
                armLen = expand(temp, i-lMin, i+lMin);
            }else{
                armLen = expand(temp, i,i);
            }
            //if armLen+i>right

            //update right
            if (i + armLen > right) {
                j = i;
                right = i+armLen;
            }
            //update the result
            if (armLen * 2 + 1 > end - start) {
                start = i-armLen;
                end = i+armLen;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (temp[i] != '#') {
                sb.append(temp[i]);
            }
        }
        return sb.toString();
    }

    private int expand(char[] s, int i, int j) {
        while (i >= 0 && j < s.length && s[i] == s[j]) {
            i--;
            j++;
        }
        return (j-i-2)/2;
    }



}
