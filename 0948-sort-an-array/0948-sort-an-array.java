class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivot = hoarePartition(arr, low, high);

            quickSort(arr,  low, pivot);
            quickSort(arr,  pivot + 1, high);
        }
    }

    public int hoarePartition(int[] arr, int low, int high){
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

    private int lomutoPartition(int[] arr, int low, int high){
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

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}