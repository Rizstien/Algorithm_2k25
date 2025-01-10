package bubblesort.standard;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {11,12,13,5,6};
        arr = bubbleSort(arr);

        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

    private static int[] bubbleSort(int[] arr){
        for(int i=0; i< arr.length-1; i++){
            boolean swapped = false;
            for(int j=0; j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            System.out.println("sweep count : "+i);
            if(!swapped) return arr;
        }
        return arr;
    }


}
