class Solution {
    public int findPeakElement(int[] nums) {
        int maxIndex =  0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[maxIndex]) maxIndex = i;
            else if(nums[i] < nums[maxIndex]) return i-1;
        }
        return maxIndex;
    }
}