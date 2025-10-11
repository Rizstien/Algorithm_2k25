class Solution {
    public boolean isPalindrome(String s) {
        HashSet<Character> charSet = new HashSet<Character>();
        for(char c='a';c<='z';c++){
            charSet.add(c);
        }
        for(char c='0';c<='9';c++){
            charSet.add(c);
        }
        
        char[] charArr = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : charArr){
            if(charSet.contains(c)) sb.append(c);
        }

        charArr = sb.toString().toCharArray();

        int i=0,j=charArr.length-1;
        while(i<=j){
            if(charArr[i]==charArr[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }
}