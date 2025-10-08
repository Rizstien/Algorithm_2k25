class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 0);
        int preSum = 0;
        for(int i=0; i<nums.length;i++){
            ans[i] = preSum + nums[i];
            preSum = ans[i];
        }
        return ans;
    }
}