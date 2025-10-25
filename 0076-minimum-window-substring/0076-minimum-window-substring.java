class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";

        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> subStringMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int[] ans = {-1,0,0};
        int l=0,r=0;
        int required = tMap.size();
        int created = 0;

        while(r<s.length()){
            char c = s.charAt(r);
            subStringMap.put(c,subStringMap.getOrDefault(c,0)+1);
            if(tMap.containsKey(c) && subStringMap.get(c).intValue() == tMap.get(c).intValue())
                created++;
            
            while(l<=r && created == required){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] > r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                l++;
                subStringMap.put(c,subStringMap.getOrDefault(c,0)-1);
                if(tMap.containsKey(c) && subStringMap.get(c) < tMap.get(c))
                    created--;
            }
            r++;
        }
        if(ans[0] == -1) return "";
        return s.substring(ans[1], ans[2]+1);




    }
}