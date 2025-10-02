class Solution {
    // Make a HashMap whos key is the num array elements and whose value is the uindex of array
    Map<Integer, Integer> valueIndex = new HashMap<>();
    public boolean containsNearbyDuplicate(int[] nums, int k) {    
        for(int i=0;i<nums.length;i++){
            if(valueIndex.containsKey(nums[i]) && checkDistance(nums, i, k)) {
                 return true;    
            }
            else valueIndex.put(nums[i],i);
        }
        // No duplicates found or no matching condition abs(i-j) <= k found
        return false; 
    }

    private boolean checkDistance(int[] nums, int i, int k){
        int indexi = valueIndex.get(nums[i]);
        int indexj = i;
        if(Math.abs(indexi-indexj)<=k) return true;
        else return false;  
    }
}