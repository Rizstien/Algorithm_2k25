class Solution {
    public int majorityElement(int[] nums) {
        int majorityRatio = nums.length/2;
        Arrays.sort(nums);
        int currentNum = nums[0];
        int currentNumFreq = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==currentNum){
                currentNumFreq++;
            }else{
                if (currentNumFreq > majorityRatio) return currentNum;
                currentNum = nums[i];
                currentNumFreq = 1;
            }
        }
        return currentNum;
    }
}