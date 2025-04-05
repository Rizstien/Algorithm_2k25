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

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}