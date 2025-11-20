class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        char[] charArr = s.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(freq[charArr[i]-'a']==1) return i;
        }

        return -1;
    }
}