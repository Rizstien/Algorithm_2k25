class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                stack.push(c);
            }else {
                if(stack.empty()) return false;
                char openingBracket = stack.pop();
                if(map.get(c) != openingBracket) return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}