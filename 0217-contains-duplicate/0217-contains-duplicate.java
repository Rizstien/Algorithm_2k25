class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();   // O(n) - space complexity
        for(int e : nums){   // O(n) - Time complexity 
            if(set.contains(e)) return true;   // O(1) - time complexity
            else set.add(e);   // O(1) - time complexity
        }
        return false;
    }
}