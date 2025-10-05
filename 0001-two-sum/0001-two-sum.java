class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        int[] result = new int[2];
        // Put all values in a map where the value is key and inxed is value
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        // Iterate in O(n) and check if the remaing value is present in map O(1)
        for(int i=0;i<nums.length;i++){
            result[0] = i;
            Integer secondIndex = map.get(target-nums[i]);
            if(secondIndex!=null && secondIndex!=i){
                result[1] = secondIndex;
                break;
            }
        }
        return result;
    }
}