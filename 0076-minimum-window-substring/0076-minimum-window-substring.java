class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return "";

        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c,0)+1);
        }

        Map<Character, Integer> subStringMap = new HashMap<Character, Integer>();
        int r=0,l=0;
        int[] ans = {-1, 0, 0};
        int required = tMap.size();
        int created = 0;

        while(r < s.length()){
            char c = s.charAt(r);
            subStringMap.put(c, subStringMap.getOrDefault(c,0) + 1);
            if(tMap.containsKey(c) && tMap.get(c).intValue() == subStringMap.get(c).intValue()) created++;
            while(l<=r && required == created){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] > r - l + 1){
                    ans[0] = r - l +1;
                    ans[1] = l;
                    ans[2] = r;
                }
                subStringMap.put(c, subStringMap.get(c) - 1);
                if(tMap.containsKey(c) && subStringMap.get(c).intValue() < tMap.get(c).intValue()) created--;
                l++;
            }
            r++;
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1], ans[2]+1);
    }
}