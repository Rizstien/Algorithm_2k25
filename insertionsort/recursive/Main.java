package insertionsort.recursive;

public class Main {
    public static void main(String[] args) {
        int[] arr = {12,11,13,5,6};
        insertionSort(arr, arr.length);
        for(int i : arr){
            System.out.println(i);
        }
    }

    private static void insertionSort(int[] arr, int n){
         if(n<=1) return;

         insertionSort(arr, n-1);

         int key = arr[n-1];
         int j = n-2;

         while(j>=0 && arr[j]>key){
             arr[j+1] = arr[j];
             j--;
         }
         arr[j+1] = key;
    }
}
