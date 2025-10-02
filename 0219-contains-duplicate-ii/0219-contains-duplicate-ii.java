class Solution {
    // Make a HashMap whos key is the num array elements and whose value is the index of array
    Map<Integer, Integer> valueIndex = new HashMap<>(); //O(n) space complexity
    public boolean containsNearbyDuplicate(int[] nums, int k) {    
        for(int i=0;i<nums.length;i++){   //O(n)  time complexity
            // check if the value already exist in map then what was its previous index and verify with new duplicate value index if it satisfys the condition  then return true. Otherwise add/replce the value index in map so it replces with new index for newxt time condition check
            if(valueIndex.containsKey(nums[i]) && checkDistance(nums, i, k)) return true;    
            else valueIndex.put(nums[i],i);
        }
        // No duplicates found or no matching condition abs(i-j) <= k found
        return false; 
    }

    //  check if the distance between duplicate value indexesis satisfying condition
    private boolean checkDistance(int[] nums, int i, int k){
        int indexi = valueIndex.get(nums[i]);
        int indexj = i;
        if(Math.abs(indexi-indexj)<=k) return true;
        else return false;  
    }
}