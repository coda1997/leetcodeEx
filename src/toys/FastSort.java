package toys;

public class FastSort {

    int binarySearch(int arr[], int key) {
        int left = 0;
        int right = arr.length-1;
        int mid;
        while (left <= right) {
            mid=(left+right)/2;
            if (key<arr[mid]){
                right=mid-1;
            }else if (key>arr[mid]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }


    public void sort(int[] a, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int key = a[l];
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
                i++;
            }
            while (i < j && a[i] < key) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = key;
        sort(a, l, i - 1);
        sort(a, i + 1, r);
    }

    public static void main(String[] args) {
        FastSort sort = new FastSort();
        int[] a = new int[]{10, 9, 4, 5, 7, 6, 3, 2, 1, 8};
        sort.sort(a, 0, 9);
        System.out.println(sort.binarySearch(a,10));
//        for (int i :
//                a) {
//            System.out.println(i);
//        }
    }
}
