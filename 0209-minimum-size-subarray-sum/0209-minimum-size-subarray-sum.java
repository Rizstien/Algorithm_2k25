class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int size = Integer.MAX_VALUE;
        int sum = 0;
        int i=0,j=0;
        while(j<nums.length){
            sum += nums[j];
            while(sum>=target){
                size = Math.min(j-i+1,size);
                sum = sum-nums[i];
                i++;
            }
            j++;
        }

        return size==Integer.MAX_VALUE?0:size;
    }
}