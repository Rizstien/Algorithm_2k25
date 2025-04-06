package quicksort.lomuto;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(i-> System.out.println(i));
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low<high){  // run this untill the low index ramins in bound and stayes less then high index
            int pivot = lomutoPartition(arr, low, high);  //find pivot index
            quickSort(arr, low, pivot-1); // sort left hald of array untill before pivot
            quickSort(arr, pivot+1, high); // sort right half of array just after pivot
            // the pivot value is already in right position during finding pivot operation
        }
    }

    private static int lomutoPartition(int[] arr, int low, int high){
        int pivot = arr[high];  // as lumoto partitioning formula assume the highest element as pivot
        int i = low-1; // this keeps the index of last element that is smaller or equal to pivot

        for(int j=low; j<high; j++){
            if(arr[j] < pivot){   // the element at i index should be smaller then pivot not j so swap their positions
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, high);   // now put the pivot at right position that is after the one smaller element then pivot
        return i+1; // return pivot position
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


