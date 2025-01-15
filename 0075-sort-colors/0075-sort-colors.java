class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] arr, int low, int high){
        if(low<high){

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot-1);
            quickSort(arr, pivot+1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j=low;j<high;j++){
            if(arr[j]<=arr[high]){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}