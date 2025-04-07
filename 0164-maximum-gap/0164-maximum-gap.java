class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if(min == max) return 0;

        int bucketSize = Math.max(1, (max-min)/(nums.length-1));
        int bucketCount = (max-min)/bucketSize + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];

        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        for(int num : nums){
            int bucketIndex = (num-min)/bucketSize;
            bucketMin[bucketIndex] = Math.min(bucketMin[bucketIndex], num);
            bucketMax[bucketIndex] = Math.max(bucketMax[bucketIndex], num);
        }

        int maxGap = 0;
        int prevMax = min;
        for(int i=0;i<bucketCount;i++){
            if(bucketMin[i]==Integer.MAX_VALUE) continue;
            maxGap = Math.max(maxGap, bucketMin[i]-prevMax);
            prevMax = bucketMax[i];
        }
        return maxGap;

    }
}
