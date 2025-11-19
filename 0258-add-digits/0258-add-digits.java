class Solution {
    public int addDigits(int num) {
        while(num/10 != 0){
            num = sumOfDigits(num);
        }
        return num;
    }

    public int sumOfDigits(int n) {
        int sum = 0;
        while(n/10 != 0){
            sum += n%10;
            n = n/10;
        }
        return sum+n;
    }
}