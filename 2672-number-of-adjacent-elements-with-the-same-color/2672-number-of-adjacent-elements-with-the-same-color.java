class Solution {
    public int[] colorTheArray(int n, int[][] queries) {

        int[] result = new int[queries.length];
        int[] colors = new int[n];
        int same = 0;

        for(int i=0;i<queries.length;i++){
            int index = queries[i][0];
            int newColor = queries[i][1];
            int oldColor = colors[index];

            // remove old contributions
            if(oldColor != 0){
                if(index>0 && colors[index-1] == oldColor) same--;
                if(index<n-1 && colors[index+1] == oldColor) same--;
            }

            // update color
            colors[index] = newColor;

            // update new contributions
            if(newColor != 0){
                if(index>0 && colors[index-1] == newColor) same++;
                if(index<n-1 && colors[index+1] == newColor) same++;
            }

            result[i] = same;
        }

        return result;
        
    }
}