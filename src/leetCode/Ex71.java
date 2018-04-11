package leetCode;

import java.util.Stack;
import java.util.StringTokenizer;

public class Ex71 {
    public String simplifyPath(String path) {
        StringTokenizer stringTokenizer = new StringTokenizer(path,"/");
        Stack<String> stack = new Stack<>();
        while (stringTokenizer.hasMoreTokens()){
            String s = stringTokenizer.nextToken();
            switch (s) {
                case "..":
                    if (stack.empty()) break;
                    stack.pop();
                    break;
                case ".":
                    break;
                default:
                    stack.push(s);
                    break;
            }
        }
        if (stack.empty()) return "/";
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()){
            stringBuilder.insert(0,"/"+stack.pop());
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Ex71 ex71 = new Ex71();
        System.out.println(ex71.simplifyPath("/a/./b/../../c/"));
    }
}
