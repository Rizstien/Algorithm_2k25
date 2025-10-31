class Solution {
    public List<String> generateParenthesis(int n) {
        // Time	O(Cₙ × n) ≈ O(4ⁿ / √n)	Generates all valid sequences
        // Space (recursion)	O(n)	Call stack + current path
        // Space (total including output)	O(Cₙ × n)	To store all generated strings
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }


    // rule 1: for every valid ans, it should start with a opening bracket
    // rule 2: at any moment the closing brackets can be equal or less then the opening brackets
    // rule3 3: we can only add a closing bracket if there is a opening bracket before that
    public void backtrack(List<String> ans, StringBuilder curr, int open, int close, int n){
        if(curr.length()==n*2){
            ans.add(curr.toString());
            return;
        }

        if(open<n){
            curr.append("(");
            backtrack(ans, curr, open+1, close, n);
            curr.deleteCharAt(curr.length()-1);
        }

        if(close<open){
            curr.append(")");
            backtrack(ans, curr, open, close+1, n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}