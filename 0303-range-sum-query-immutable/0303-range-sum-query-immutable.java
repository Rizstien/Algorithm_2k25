class NumArray {

    int[] sumArray; 
    public NumArray(int[] nums) {
        sumArray = new int[nums.length+1];

        for(int i=0;i<nums.length;i++){
            sumArray[i+1] = sumArray[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int leftSum = sumArray[left];
        int rightSum = sumArray[right+1];
        return rightSum - leftSum;    
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */