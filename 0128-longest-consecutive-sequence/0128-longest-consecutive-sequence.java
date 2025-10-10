class Solution {

    // Solution that works in O(nlogn)  due to sorting but takes no extra memory
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



// Other solution that uses Hashset to get rid of duplicates but runs in O(n^2)  and takses O(n) extra memory
/*
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 ) return 0;
        Set<Integer> numSet = new HashSet<>();
        int longestSeq = 1;
        for(int num : nums){
            numSet.add(num);
        }

        for(int num : numSet){
            if(numSet.contains(num-1)) continue;
            else{
                int current = num;
                int currentSeq = 1;
                while(numSet.contains(current+1)){
                    currentSeq++;
                    current++;
                }
                longestSeq = Math.max(currentSeq, longestSeq);
            }
        }

        return longestSeq;
    }

*/

}