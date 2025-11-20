class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        for(Character c : charArr){
            if(map.containsKey(c)) stack.push(c);
            else{
                if(!stack.isEmpty()){
                    if(c.equals(map.get(stack.peek()))){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.isEmpty();
        
    }
}