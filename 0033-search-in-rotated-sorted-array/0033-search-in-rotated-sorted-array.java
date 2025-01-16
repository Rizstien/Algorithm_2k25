class Solution {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length-1, target);
    }

    public int search(int[] nums, int left, int right, int target){
        int mid = right + (left - right)/2;

        if(left > right) return -1;

        if(nums[mid] == target) return mid;

        if(nums[mid] == nums[left] && nums[right] == nums[mid]){
            left++;
            right--;
        }else if(nums[left] <= nums[mid]){
            if(target >= nums[left] && target < nums[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }else{
            if(target <= nums[right] && target > nums[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return search(nums, left, right, target);
    }
}