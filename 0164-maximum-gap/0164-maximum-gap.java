class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if(n < 2) return 0;


        // find the range of numbers in array
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        if(min == max) return 0;

        // create the buckets equal to the range of number and make copy
        // firts find the size of bucket
        int bucketSize = Math.max(1, (max-min)/(n-1));

        // now find the total buckets required
        int bucketCount = (max-min)/bucketSize+1;
        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // place each number in its correponding bucket
        for(int num : nums){
            int bucketIdx = (num - min)/bucketSize;
            bucketMin[bucketIdx] = Math.min(bucketMin[bucketIdx], num);
            bucketMax[bucketIdx] = Math.max(bucketMax[bucketIdx], num);
        }

        // now calculate the max gap
        int maxGap = 0;
        int prevMax = min;
        for(int i=0; i< bucketCount; i++){
            if(bucketMin[i] == Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;

    }
}
