class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char c : s1.toCharArray()){
            freq1[c-'a']++;
        }

        int l=0;
        int r=l+s1.length()-1;

        for(int i=l;i<=r;i++){
            freq2[s2.charAt(i)-'a']++;
        }

        while(l<=r && r<s2.length()){
            if(Arrays.equals(freq1, freq2)) return true;
            else{
                freq2[s2.charAt(l++)-'a']--;
                if(++r<s2.length())
                    freq2[s2.charAt(r)-'a']++;
            }
        }
        return false;
    }
}