class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();

        for(int num :  nums){
            heap.add(num);
        }

        int limit = heap.size()-k;
        for(int i=0;i<limit;i++){
            heap.poll();
        }

        return heap.peek();
    }
}