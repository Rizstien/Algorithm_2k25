package selectionsort.standard;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        selectionSort(arr);
        Arrays.stream(arr).forEach(i-> System.out.println(i));
    }

    private static int[] selectionSort(int[] arr){

        for(int i=0;i<arr.length;i++){
            int minIndex = findMinIndex(arr,i);
            if(minIndex!=i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }

    private static int findMinIndex(int[] arr, int start){
        int minIndex = start;
        for(int i = start+1;i<arr.length;i++){
            if(arr[i]<arr[minIndex]) minIndex = i;
        }
        return minIndex;
    }
}
