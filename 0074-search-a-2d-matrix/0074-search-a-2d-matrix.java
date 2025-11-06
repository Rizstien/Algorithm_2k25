class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int top = 0;
        int bottom = matrix.length-1;

        while(top<=bottom){
            int mid = top + (bottom-top)/2;
            if(matrix[mid][0]==target || matrix[mid][matrix[mid].length-1]==target) return true;

            else if(matrix[mid][0] < target && matrix[mid][matrix[mid].length-1] > target){
                if(binarySearch(matrix[mid], target)) return true;
                else return false;
            }else if(matrix[mid][0] < target && matrix[mid][matrix[mid].length-1] < target){
                top = mid+1;
            }else{
                bottom = mid-1;
            }

        }

/*
        for(int[] nums : matrix){
            if(nums[0]==target || nums[nums.length-1]==target) return true;
            else if(nums[0] < target && nums[nums.length-1] > target){
                if(binarySearch(nums, target)) return true;
                else return false;
            }
        }
        */
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int center = left+(right-left)/2;

            if(nums[center] == target) return true;
            else if(nums[center]<target){
                left = center+1;
            }else{
                right = center-1;
            }
        }
        return false;
    }
}