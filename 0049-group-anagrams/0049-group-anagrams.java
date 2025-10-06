class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Make a hashmap to hold all the anagrams against a similar pattren
         Map<String, List<String>>  map = new HashMap<>(); //O(n)  space
         // Iterate over all strings array 
         for(String str: strs){   // O(n)  time
            
            int[] count = new int[26];
            for(char c : str.toCharArray()){  //O(k) time
                count[c-'a']++;
            }
            
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){ //O(1)
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());   // O(1)
            }
            map.get(key).add(str);  // O(1)
         }
         return new ArrayList<>(map.values());
    }


    // Overall O(n) space complexity  +  O(n x k) time complexity

}