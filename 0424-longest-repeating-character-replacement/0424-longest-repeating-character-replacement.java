class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,ans=0,maxFreq=0;
        int[] freq = new int[26];

        while(r<s.length()){
            maxFreq = Math.max(maxFreq,++freq[s.charAt(r) - 'A']);
            while(r-l+1 - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
                //maxFreq = Arrays.stream(freq).max().getAsInt();
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}