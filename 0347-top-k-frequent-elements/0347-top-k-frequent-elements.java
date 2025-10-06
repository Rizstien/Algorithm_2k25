class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==k) return nums;

        // Initialize a mapo that wil contain the frequency of each element
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int[] result = new int[k];

        // iterate through whole array and put the frequncy in the map
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        // make a custom heap with comparator that add that keep the high frequncy values on priority
        Queue<Integer> heap = new PriorityQueue<>(
            (a, b) -> freq.get(a) - freq.get(b)
        );

        // iterate through all the keyset of freq map and put in heap based on frequency
        for(int num : freq.keySet()){
            heap.add(num);
            if(heap.size()>k) heap.poll();  // no need to keep more then k elements to save space so poll the low freq elements
        }

        for(int i=0;i<k;i++){
            result[i] = heap.poll();    // build the result array from heap
        }

        return result;
    }
}