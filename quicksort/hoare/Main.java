package quicksort.hoare;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(i-> System.out.println(i));
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = hoarePartition(arr, low, high);

            quickSort(arr,  low, pivot);
            quickSort(arr,  pivot + 1, high);
        }
    }

    public static int hoarePartition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while(true){
            do{
                i++;
            }while(arr[i] < pivot);

            do{
                j--;
            }while(arr[j] > pivot);

            if(i < j){
                swap(arr, i, j);
            } else {
                return j;
            }
        }

    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
