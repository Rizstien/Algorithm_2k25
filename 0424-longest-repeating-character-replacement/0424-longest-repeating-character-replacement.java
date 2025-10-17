class Solution {
    public int characterReplacement(String s, int k) {
        // solve this with 2 PTR and sliding window technique.
        // start with lefta and right at the begining tof the strring and then start moving right
        // ptr to right and increase the frequency of each charcter in freq array to find which char has max frequency.
        // so at any point in time check this condition theat the lentgth of substring between right and left  minus the max occurence of any charcter if it is less then k then we can repolace any charcter with k time and get max same charcter substring. if the length - max freq increase then k then we need to move left pointer and decrease freqncy of those chactres at left pointer position sinc ethe substring is shirking now and need toi keep the length - maxFreq <= k condition true. at the end the max of length is the answer.
        
        int l=0,r=0,ans=0,maxFreq=0;
        int[] freq = new int[26];  // O(1) space complexity

        while(r<s.length()){   // time O(n)
            maxFreq = Math.max(maxFreq,++freq[s.charAt(r) - 'A']);
            while(r-l+1 - maxFreq > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}