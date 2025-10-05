class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();

        // Iterate in O(n) and check if the remaing value is present in map O(1)
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            if(map.containsKey(target-value)){
                return new int[]{map.get(target-value), i};
            }else{
                map.put(value, i); 
            }
        }
        return new int[]{};
    }
}