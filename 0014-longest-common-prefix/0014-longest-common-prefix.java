class Solution {
    public String longestCommonPrefix(String[] strs) {

        //B.F
        /*
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
        */

        if (strs.length == 0) return "";

        Arrays.sort(strs);

        String first = strs[0];
        String last  = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() 
                && i < last.length() 
                && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}