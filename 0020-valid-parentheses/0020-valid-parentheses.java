class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']'){
                if(stack.empty()) return false;
                char openingBracket = stack.pop();
                if(c == ')' && openingBracket != '(') return false;
                else if(c == '}' && openingBracket != '{') return false;
                else if(c == ']' && openingBracket != '[') return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }
}