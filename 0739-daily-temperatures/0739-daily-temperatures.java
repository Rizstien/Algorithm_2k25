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

        Stack<Integer> stack = new Stack<>(); // O(n)  space
        stack.push(0);
        for(int i=1;i<temp.length;i++){  // O(n) time
            int curr = temp[i];
            while(!stack.isEmpty() && curr>temp[stack.peek()]){
                int topNodeIdx = stack.pop();
                ans[topNodeIdx] = i - topNodeIdx;
            }
            stack.push(i);
        }
        return ans;
    }
}
