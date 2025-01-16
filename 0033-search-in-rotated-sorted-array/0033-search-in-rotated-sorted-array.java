class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0,nums.length-1, target);
    }

    public int search(int[] nums, int start, int end, int target){
        int mid = start + (end-start)/2;

        if(start > end) return -1;

        if(target == nums[mid]) return mid;
        else if(nums[start] <= nums[mid]){
            if(target >= nums[start] && target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }else {
            if(nums[mid] < target && target <= nums[end]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return search(nums, start, end, target);
    }
}