class Solution {
    public int characterReplacement(String s, int k) {
        s = s.toLowerCase();
        int l=0,r=0,ans=0,length=0,maxFreq=0;
        int[] freq = new int[26];

        while(r<s.length()){
            length = r-l+1;
            freq[s.charAt(r) - 'a']++;
            maxFreq = Math.max(maxFreq,freq[s.charAt(r) - 'a']);
            while(length - maxFreq > k && l<s.length()){
                freq[s.charAt(l) - 'a']--;
                maxFreq = Arrays.stream(freq).max().getAsInt();
                l++;
                length = r-l+1;
            }
            ans = Math.max(ans, length);
            r++;
        }
        return ans;
    }
}