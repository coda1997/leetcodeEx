package leetCode;

public class Ex60 {
    public String getPermutation(int n, int k) {
        //initialization
        k = k - 1;
        boolean[] used = new boolean[n];
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * (i + 1);
        }
        int base = k;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n - 1; i > 0; i--) {
            int temp = base / factorial[i - 1];
            int index = 0;
            while (temp > 0) {
                if (!used[index++]) {
                    temp--;
                }
            }
            while (used[index]) {
                index++;
            }

            used[index] = true;
            stringBuilder.append(index + 1);
            base = base % factorial[i - 1];

        }
        for (int index = 0; index < n; index++) {
            if (!used[index]) {
                stringBuilder.append(index + 1);
                break;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Ex60().getPermutation(3, 4));
    }
}
