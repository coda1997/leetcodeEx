package leetCode;

public class Ex151 {
    public String reverseWords(String s) {
        if (s==null||s.length()<=1){
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] temp = s.split(" ");
        for (int i = temp.length - 1; i >= 0; i--) {
            String t = temp[i];
            if (t.length()==0){
                continue;
            }
            stringBuilder.append(t).append(" ");
        }
        if (stringBuilder.length()==0){
            return "";
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        return stringBuilder.toString();
    }
}
