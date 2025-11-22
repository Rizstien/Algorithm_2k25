class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = 
            new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> e : list){
            int freq = e.getValue();
            while(freq>0){
                sb.append(e.getKey());
                freq--;
            }
        }
        return sb.toString();
    }
}