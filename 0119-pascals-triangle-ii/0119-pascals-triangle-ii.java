class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = generate(rowIndex+1);
        return result.get(rowIndex);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<numRows;i++){

            if(i==0) {
                result.add(new ArrayList<Integer>(Arrays.asList(1)));
                continue;
            }else if(i==1) {
                List<Integer> currentRow = new ArrayList<Integer>(Arrays.asList(1));
                currentRow.add(1);
                result.add(currentRow);
                continue;
            }else{
                List<Integer> currentRow = new ArrayList<Integer>(Arrays.asList(1));
                List<Integer> prevRow = result.get(i-1);
                for(int j=1;j<i;j++){
                    currentRow.add(prevRow.get(j)+prevRow.get(j-1));
                }
                currentRow.add(1);
                result.add(currentRow);
            }
        }
        return result;
    }
}