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
                if(stack.size() <= 0) return false;
                char openingBracket = stack.pop();
                if(c == ')' && openingBracket != '(') return false;
                else if(c == '}' && openingBracket != '{') return false;
                else if(c == ']' && openingBracket != '[') return false;
            }
        }
        if(stack.size() == 0) return true;
        return false;
    }
}