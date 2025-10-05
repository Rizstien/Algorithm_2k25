class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Make a hashmap to hold all the anagrams against a similar pattren
         Map<String, List<String>>  map = new HashMap<>(); //O(n)  space
         // Iterate over all strings array 
         for(String str: strs){     // O(n)  time
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);   // O(kLogk)
            String key = String.valueOf(charArr);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());   // O(1)
            }
            map.get(key).add(str);  // O(1)
         }
         return new ArrayList<>(map.values());
    }


    // Overall O(n) space complexity  +  O(n x kLogk)  =  O(N*K) 

}