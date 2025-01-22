class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        long value = 1;
        result.add((int) value);
        for(int i=1;i<=rowIndex;i++){
            value = value * (rowIndex -i+1)/i;
            result.add((int) value);
        }
        return result;
    }
}