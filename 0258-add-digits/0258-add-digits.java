class Solution {
    public int addDigits(int num) {

        while(num/10 != 0){
            num = sumOfdigits(num);
        }
        return num;
    }

    public int sumOfdigits(int num){
        int sum = 0;
        while(num/10 != 0){
            sum+=num%10;
            num = num/10;
        }
        return sum+num;
    }
}