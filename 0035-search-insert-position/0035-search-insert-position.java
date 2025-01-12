class Solution {
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int index = searchInsert(nums, 0, nums.length-1, target);

        if(nums[index]==target) return index;
        else if(index==0 && target > nums[index]) return 1;
        else if(index==0 && target < nums[index]) return 0;
        else if(index==length-1 && target > nums[index]) return length;
        else if(index==length-1 && target < nums[index]) return length-1;
        else if(target < nums[index]) return index;
        else if(target > nums[index]) return index+1;
        return index;
    }


    public int searchInsert(int[] nums, int start, int end, int target) {
        if(start==end) return start;
        if(end<start) return start;
        if(start>end) return end;
        int mid = (start+end)/2;

        if(target == nums[mid]) return mid;
        else if(target > nums[mid]){
            return searchInsert(nums, mid+1, end, target);
        }else if(target < nums[mid]){
            return searchInsert(nums, start, mid-1, target);
        }
        return mid;
    }
}