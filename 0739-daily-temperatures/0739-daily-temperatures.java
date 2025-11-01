class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        
        
        int[] temp = temperatures;
        int[] ans = new int[temp.length];
        // B.F Approach
        /*
        for(int i=0;i<temp.length;i++){
            int curr = temp[i];
            for(int j=i+1;j<temp.length;j++){
                if(temp[j]>temp[i]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        */

        Stack<Node> stack = new Stack<>(); // O(n)  space
        stack.push(new Node(temp[0],0));
        for(int i=1;i<temp.length;i++){  // O(n) time
            int curr = temp[i];
            while(!stack.isEmpty() && curr>stack.peek().val){
                int topNodeIdx = stack.pop().idx;
                ans[topNodeIdx] = i - topNodeIdx;
            }
            stack.push(new Node(temp[i],i));
        }

        return ans;

    }
}

public class Node{
    Node(int val, int idx){
        this.idx=idx;
        this.val=val;
    }
    int val;
    int idx;
}