class Solution {
    public int findKthLargest(int[] nums, int k) {
        // a min heap will alwwyas retain its property of min element at top so easy to maintain sorting
        Queue<Integer> heap = new PriorityQueue<>();

        for(int num :  nums){
            heap.add(num);
            if(heap.size()>k) heap.poll();  // poll all the extra elements from heap since the min element will always be polled first so it will left with max elements 
        }

        return heap.peek();  // now the min element in heap will be the kth max element
    }
}