class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 1 && digits[0]==9) { 
            int[] result = {1,0};
            return result;
        }

        if(digits[digits.length-1]+1 < 10){
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }else{
            digits[digits.length-1] = 0;
            for(int i=digits.length-2;i>=0;i--){
                digits[i] += 1;
                if(i==0){
                    if(digits[i]<10) return digits;
                    else{
                        digits[i] = 0;
                        int[] result = new int[digits.length+1];
                        result[0] = 1;
                        for(int j=1;j<result.length;j++){
                            result[j] = digits[j-1];
                        }
                        return result;
                    }
                }
                if(digits[i]<10) return digits;
                else digits[i] = 0;
            }
        }
        return digits;
    }
}