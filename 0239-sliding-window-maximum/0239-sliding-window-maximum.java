class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // B.F approach O(n*k)
/*
        int[] msw = new int[nums.length-k+1];
        int l=0,r=l+k-1;
        while(r<nums.length){
            int max = nums[l];
            for(int i=l;i<=r;i++){
                max = Math.max(max, nums[i]);
            }
            msw[l] = max;
            l++;r++;
        }
        return msw;
*/

        // Optimal Solution O(n) space + O(k) time

        int[] msw = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i>=k-1){
                msw[i-k+1] = nums[deque.peek()];
            }
        }
        return msw;
    }
}