package selectionsort.recursive;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        selectionSort(arr, 0);
        Arrays.stream(arr).forEach(i-> System.out.println(i));
    }

    private static void selectionSort(int[] arr, int index){
        if(index>=arr.length-1) return;

        int minIndex = findMinIndex(arr,index);
        if(minIndex!=index){
            int temp = arr[index];
            arr[index] = arr[minIndex];
            arr[minIndex] = temp;
        }

        selectionSort(arr, index+1);
    }

    private static int findMinIndex(int[] arr, int start){
        int minIndex = start;
        for(int i = start+1;i<arr.length;i++){
            if(arr[i]<arr[minIndex]) minIndex = i;
        }
        return minIndex;
    }
}
