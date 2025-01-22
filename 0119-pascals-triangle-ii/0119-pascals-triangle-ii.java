class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long value = 1; // Starting value for C(n, 0)
        row.add((int) value);
        
        for (int k = 1; k <= rowIndex; k++) {
            value = value * (rowIndex - k + 1) / k; // C(n, k) = C(n, k-1) * (n-k+1)/k
            row.add((int) value);
        }
        return row;
    }
}