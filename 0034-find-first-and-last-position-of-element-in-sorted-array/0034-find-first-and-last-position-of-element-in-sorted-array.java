class Solution {
    public int[] searchRange(int[] nums, int target) {
       int firstIndex = searchFirst(nums, 0, nums.length-1, target);
       int lastIndex = searchLast(nums, 0, nums.length-1, target);
       return new int[]{firstIndex,lastIndex};
    }

    public int searchFirst(int[] nums, int start, int end, int target){
        int index = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target <= nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(target == nums[mid]) index = mid;
        }
        return index;
    }

    public int searchLast(int[] nums, int start, int end, int target){
        int index = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target >= nums[mid]){
                start = mid + 1;
            }else{
               end = mid - 1;
            }
            if(target == nums[mid]) index = mid;
        }
        return index;
    }
}