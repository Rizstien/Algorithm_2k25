class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int e : nums){
            if(set.contains(e)) return true;
            else set.add(e);
        }
        return false;
    }
}