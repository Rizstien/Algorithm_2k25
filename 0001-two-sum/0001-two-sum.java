class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        int[] result = new int[2];

        // Iterate in O(n) and check if the remaing value is present in map O(1)
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            result[0] = i;
            if(map.containsKey(target-value)){
                result[1] = map.get(target-value);
                break;
            }else{
                map.put(value, i); 
            }
        }
        return result;
    }
}