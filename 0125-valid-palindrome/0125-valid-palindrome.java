class Solution {
    public boolean isPalindrome(String s) {
 
 /*
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

*/


        int i=0,j=s.length()-1;
        while(i<j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }

        return true;
    }
}