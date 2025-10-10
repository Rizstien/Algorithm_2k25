class Solution {
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
}