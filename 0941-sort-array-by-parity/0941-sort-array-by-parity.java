class Solution {
    public int[] sortArrayByParity(int[] nums) {

        // two pinter approach. 
        //e pointer will be at every even number and o pointer will be at every odd number 
        //untill one of them is greater then length. 
        //and replce their values with each oher thebn move forward

        int even = 0,odd = 0;
        if(nums[0]%2==0) even=1;
        while(even<nums.length && odd<nums.length){
            while(even<nums.length && nums[even]%2 != 0) even++;
            while(odd<nums.length && nums[odd]%2 == 0) odd++;
            
            if(even>=nums.length || odd>=nums.length) break;

            if(odd<even){
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                odd++;
            }
            even++;
        }

        return nums;
        
    }
}