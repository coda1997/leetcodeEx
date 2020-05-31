package leetCode;

public class QuickSort {

    public void quicksort(int[] arr,int left,int right){
        //right should be len - 1
        if (left<right){
            int partionIndex = partion(arr, left, right);
            quicksort(arr,left,partionIndex-1);
            quicksort(arr,partionIndex+1,right);
        }

    }

    private int partion(int[] arr,int left,int right){
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if (arr[i]<arr[pivot]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,pivot,index-1);
        return index-1;
    }


    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }

}
