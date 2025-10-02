class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);     // O(nlogn)
        for(int i=0;i<nums.length-1;i++){   // O(n)
            if(nums[i]==nums[i+1]) return true;
        }
        return false;
    }
}