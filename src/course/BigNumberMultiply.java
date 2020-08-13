package course;

public class BigNumberMultiply {
    public String multiply(String num1, String num2) {
        if (num2.length() > num1.length()) {
            return multiply(num2, num1);
        }
        var map = new String[10];
        //num1 is longer than num2
        var ss = num1.toCharArray();
        var cc = num2.toCharArray();
        var res = "";
        for (int i = 0; i < cc.length; i++) {
            int item = cc[i]-'0';
            String temp = null;
            if(map[item]==null){
                temp = mul(ss, item);
                map[item] = temp;
            }else{
                temp = map[item];
            }
            res = add(res+"0",temp);
        }
        return res;
    }

    private String mul(char[] num1, int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int floor = 0;
        int i = num1.length - 1;
        while (i >= 0) {
            int temp = (num1[i] - '0') * n+floor;
            stringBuilder.insert(0, temp % 10);
            floor = temp / 10;
            i--;
        }
        if(floor!=0){
            stringBuilder.insert(0, floor);
        }
        return stringBuilder.toString();
    }


    private String add(String num1, String num2) {
        int floor = 0;
        StringBuilder stringBuilder = new StringBuilder();
        var cc = num1.toCharArray();
        var ss = num2.toCharArray();
        int i = cc.length - 1;
        int j = ss.length - 1;
        while (i >= 0 && j >= 0) {
            int temp = (cc[i] - '0') + (ss[j] - '0') + floor;
            stringBuilder.insert(0, temp % 10);
            floor = temp / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int temp = (cc[i] - '0') + floor;
            stringBuilder.insert(0, temp % 10);
            floor = temp / 10;
            i--;
        }
        while (j >= 0) {
            int temp = (ss[j] - '0') + floor;
            stringBuilder.insert(0, temp % 10);
            floor = temp / 10;
            j--;
        }
        if (floor != 0) {
            stringBuilder.insert(0, floor);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        var o = new BigNumberMultiply();
        System.out.println(o.multiply("123", "456"));
    }
}
