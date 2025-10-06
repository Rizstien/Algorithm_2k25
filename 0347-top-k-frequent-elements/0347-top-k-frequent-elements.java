class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Initialize a mapo that wil contain the frequency of each element
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int[] result = new int[k];

        // iterate through whole array and put the frequncy in the map
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );
        
        for(int num : freq.keySet()){
            heap.add(num);
            if(heap.size()>k) heap.poll();
        }

        for(int i=0;i<k;i++){
            result[i] = heap.poll();
        }

        return result;
    }
}