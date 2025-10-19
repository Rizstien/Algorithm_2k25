class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char c : s1.toCharArray()){
            freq1[c-'a']++;
        }

        int l=0;
        int r=l+s1.length()-1;

        while(l<=r && r<s2.length()){
            freq2 = new int[26];
            for(int i=l;i<=r;i++){
                freq2[s2.charAt(i)-'a']++;
            }

            if(Arrays.equals(freq1, freq2)) return true;
            else{
                l++;
                r++;
            }
        }
        return false;
    }
}