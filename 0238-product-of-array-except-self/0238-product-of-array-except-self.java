class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[]  pre = new int[nums.length];
        int[]  post = new int[nums.length];
        int[]  ans = new int[nums.length];

        // Populate a prefix product array for every element and assume that if there is no prefix to an element then it is 1
        int prevProd = 1;
        for(int i=0;i<nums.length;i++){
            if(i-1<0){
                pre[i] = 1;
            } else{
                pre[i] = nums[i-1]*pre[i-1];
            } 
        }

        // Populate a postfix product array for every element and assume that if there is no postfix to an element then it is 1
        int postProd = 1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+1>nums.length-1){
                post[i] = 1;
            } else{
                post[i] = nums[i+1]*post[i+1];
            } 
        }

        // multiply both array and that is answer
        for(int i=0;i<nums.length;i++){
            ans[i] = pre[i]*post[i];
        }

        return ans;
    }
}