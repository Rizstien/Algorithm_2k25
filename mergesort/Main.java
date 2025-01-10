package mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        mergeSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(i-> System.out.println(i));
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right-left+1];
        int i = left, j = mid + 1, k = 0;

        while(i<=mid && j<=right){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;k++;
            }else{
                temp[k] = arr[j];
                j++;k++;
            }
        }

        while(i<=mid){
            temp[k] = arr[i];
            i++;k++;
        }

        while(j<=right){
            temp[k] = arr[j];
            j++;k++;
        }

        for(i=left;i<=right;i++){
            arr[i] = temp[i-left];
        }
    }
}
