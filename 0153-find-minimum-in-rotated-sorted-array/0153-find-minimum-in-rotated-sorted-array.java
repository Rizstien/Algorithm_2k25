class Solution {
    public int findMin(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        // B.F
        /*
        for(int num :  nums){
            min = Math.min(num,min);
        }
        */

        if(nums.length==1) return nums[0];

        int left = 0, right = nums.length-1;
        int mid = left + (right-left)/2;
        //this is non rotated or rotated n-times case
        if(nums[mid]>nums[left] && nums[mid]<nums[right]) return nums[left];

        // rotated array cases
        while(left<=right){
            if(nums[left]<nums[right]){
                min = Math.min(nums[left],min);
            }
            mid = left + (right-left)/2;
            min = Math.min(nums[mid],min);
            if(nums[mid]>=nums[left]){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        return min;
    }
}