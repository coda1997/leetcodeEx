package leetCode;

public class ex1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cs = new int[1001];
        for (int i : arr1) {
            cs[i]++;
        }
        int p = 0;
        for (int i : arr2) {
            while (cs[i] > 0) {
                arr1[p++] = i;
                cs[i]--;
            }
        }
        int index = 0;
        while (index < 1001) {
            if (cs[index] > 0) {
                cs[index]--;
                arr1[p++] = index;
            } else {
                index++;
            }
        }
        return arr1;

    }
}
