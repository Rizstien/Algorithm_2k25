class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            int remaining = target - numbers[i];
            int j = search(numbers, remaining);
            if(j != -1 && j != i){
                if(i<j){
                    result[0] = i+1;
                    result[1] = j+1;
                }else{
                    result[0] = j+1;
                    result[1] = i+1;
                }
                
                return result;
            }
        }
        return result;
    }

    public int search(int[] numbers, int target){
        int left = 0;
        int right = numbers.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(numbers[mid]==target){
                return mid;
            }else if(numbers[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}