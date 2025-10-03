class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length==1){
            result.add(List.of(strs[0]));
            return result;
        }

        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals("1")){
                List<String> group = new ArrayList(List.of(strs[i]));
                for(int j=i+1;j<strs.length;j++){
                    if(!strs[j].equals("1") && isAnagram(strs[i], strs[j])){
                        group.add(strs[j]);
                        strs[j] = "1";
                    }
                }
                strs[i] = "1";
                result.add(group);
            }
        }
        return result;
    }

    private boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        
        // make an array of size 26 and fill with zeros to track the frequency of each charcter in both strings
        int[] freq = new int[26];   //O(1) space complexity
        Arrays.fill(freq, 0);       // O(1)  time complexity

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        // since both string are same length so just one iterator will be enough for both arrays iteration
        for(int i=0;i<sArr.length;i++){    //  O(n)  time complexity
            freq[sArr[i] - 'a']++;  // just plus one at same index as of charcter in freq array
            freq[tArr[i] - 'a']--; // just minus one at same index as of charcter in freq array
        }
        // at the end of this iteration if the strings are anagrams and have same charcters wirth same frequency they should have cancel each other frequency

        // at the end just check if the whole array is not all 0 then they are not anagram
        for(int i=0;i<freq.length;i++){   // O(1)   time complexity
            if(freq[i]!=0) return false;
        }
        return true;
    }

}