class Solution {
    public int[] colorTheArray(int n, int[][] queries) {

        int[] result = new int[queries.length];
        int[] colors = new int[n];

        int same = 0;
        for(int i=0;i<queries.length;i++){
            int index = queries[i][0];
            int newColor = queries[i][1];
            int oldColor = colors[index];

            if(oldColor != 0){
                // remove old contributions
                if(index>0 && oldColor == colors[index-1]) same--;
                if(index<n-1 && oldColor == colors[index+1]) same--;
            }

            colors[index] = newColor;

            if(newColor != 0){
                // add new contributions
                if(index>0 && newColor == colors[index-1]) same++;
                if(index<n-1 &&  newColor == colors[index+1]) same++;
            }
            result[i] = same;
        }

        return result;
    }
}