class Solution {
    public String longestCommonPrefix(String[] strs) {

        //B.F
        if(strs.length==1) return strs[0];
        String first = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<first.length();i++){
            char c = first.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || c != strs[j].charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}