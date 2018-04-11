
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        System.out.println(String.valueOf(mut(Long.valueOf(s1), Long.valueOf(s2))));
        System.out.println(mut2(s1,s2));
    }

    static long mut(long num1,long num2){
        if (num1<10||num2<10){
            return num1*num2;
        }
        int len1 = String.valueOf(num1).length();
        int len2 = String.valueOf(num2).length();
        int half = Math.max(len1,len2)/2;
        long a = Long.valueOf(String.valueOf(num1).substring(0, len1 - half));
        long b = Long.valueOf(String.valueOf(num1).substring(len1 - half));
        long c = Long.valueOf(String.valueOf(num2).substring(0, len2 - half));
        long d = Long.valueOf(String.valueOf(num2).substring(len2 - half));
        long ac = mut(a, c);
        long bd = mut(b, d);
        long z = mut(a + b, c + d) -ac-bd;
        return (long) (ac*Math.pow(10,(2*half))+z*Math.pow(10,half)+bd);
    }
    static String mut2(String s1,String s2){
        int[] num1 = new int[s1.length()];
        int[] num2 = new int[s2.length()];
        for (int i =0;i<s1.length();i++){
            num1[i]= (int) s1.charAt(i)-'0';
        }
        for (int i =0;i<s2.length();i++){
            num2[i]= (int) s2.charAt(i)-'0';
        }
        int[] res = new int[num1.length+num2.length+1];
        for (int i =0;i<num1.length;i++){
            for (int j =0;j<num2.length;j++){
                res[i+j+1]+=num1[i]*num2[j];
            }
        }
        for (int i = res.length-1;i>0;i--){
            if (res[i]>10){
                res[i-1] +=res[i]/10;
                res[i] = res[i]%10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (res[0]!=0){
            stringBuilder.append(res[0]);
        }
        for (int i = 1;i<res.length-1;i++){
            stringBuilder.append(res[i]);
        }
        if (res[res.length-1]!=0){
            stringBuilder.append(res[res.length-1]);
        }
        return stringBuilder.toString();
    }
}