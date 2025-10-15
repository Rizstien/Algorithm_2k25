class Solution {
    public int lengthOfLongestSubstring(String s) {

        /*
        // My Attempted Solution
        if(s.length()==1) return 1;
        Set<Character> set = new HashSet<Character>();
        int longest = 0, local=0;
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                local++;
            }else{
                longest = Math.max(longest,local);
                //set.clear();
                set.add(s.charAt(i));
                local = 1;
            }
        }
        return Math.max(longest,local);
        */


        Set<Character> visited = new HashSet<>();
        int l=0,r=0,ans=0;
        while(r<s.length()){
            char c = s.charAt(r);
            while(visited.contains(c)){
                visited.remove(s.charAt(l));
                l++;
            }
            visited.add(c);
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;

    }
}