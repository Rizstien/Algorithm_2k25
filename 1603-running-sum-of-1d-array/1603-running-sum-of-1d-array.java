class Solution {
    public int[] runningSum(int[] nums) {
        int preSum = 0;
        for(int i=0; i<nums.length;i++){
        // Take current value and add previous Sum and replace the current value
            nums[i] = preSum + nums[i]; 
        // new preSum will be the current sum calculated and it will be used in next iteration
            preSum = nums[i];
        }
        return nums;
    }
}