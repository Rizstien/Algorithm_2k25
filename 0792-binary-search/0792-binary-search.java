class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int center = left+(right-left)/2;

            if(nums[center] == target) return center;
            else if(nums[center]<target){
                left = center+1;
            }else{
                right = center-1;
            }
        }
        return -1;
    }
}