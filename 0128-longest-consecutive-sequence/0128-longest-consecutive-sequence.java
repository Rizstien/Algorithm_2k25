class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 ) return 0;
        if(nums.length == 1 ) return 1;
        Arrays.sort(nums);
        int longestSeq = 1, globalLongest = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] == 0) continue;
            else if(Math.abs(nums[i]-nums[i-1]) == 1) longestSeq++;
            else longestSeq = 1;
            globalLongest = Math.max(longestSeq, globalLongest);
        }
        return globalLongest;
    }
}