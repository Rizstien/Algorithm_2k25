class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val) {
                nums[i] = -1;
                k++;
            }
        }

        int i = 0, temp = 0;
        int j = nums.length-1;
        while(i < j){
            if(nums[i] == -1){
                if(nums[j] != -1){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                }
                j--;
            }else i++;
        }
        return nums.length - k;
    }
}