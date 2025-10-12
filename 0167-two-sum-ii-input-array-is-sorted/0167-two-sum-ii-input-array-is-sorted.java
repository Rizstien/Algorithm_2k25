class Solution {
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<numbers.length;i++){
            Integer secondIdx = map.get(target-numbers[i]);
            if(secondIdx!=null) return new int[]{secondIdx, i+1};
            else map.put(numbers[i], i+1);
        }
        return new int[2];
    }
}