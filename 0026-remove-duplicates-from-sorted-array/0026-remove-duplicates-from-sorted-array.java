class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == -101) continue;
            int key = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j] == key){
                    nums[j] = -101;
                    k++;
                }
            }
        }

        int i=0,j=0;

        while(i<nums.length-1 && j<nums.length-1){
            while(i<nums.length-1 && nums[i] != -101) i++;
            j=i+1;
            while(j<nums.length-1 && nums[j] == -101) j++;
            if(i>=nums.length || j>=nums.length) break;
            if(i<j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else break;
        }


        return nums.length - k;
    }
}