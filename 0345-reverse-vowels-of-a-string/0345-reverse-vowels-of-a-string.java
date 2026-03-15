class Solution {
    public String reverseVowels(String s) {
        // two pinters approach
        Set<Character> vowels = Set.of('a','e','i','o','u');
        char[] sArr = s.toCharArray();
        int left=0;
        int right=sArr.length-1;

        while(left < right){
            while(left<=right && !vowels.contains(Character.toLowerCase(sArr[left]))) left++;
            while(left<=right && !vowels.contains(Character.toLowerCase(sArr[right]))) right--;
            if(left<right){
                char temp = sArr[left];
                sArr[left] = sArr[right];
                sArr[right] = temp;
                left++;
                right--;
            }
        }

        return String.valueOf(sArr);
    }
}