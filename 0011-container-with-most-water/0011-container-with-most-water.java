class Solution {
    public int maxArea(int[] height) {
        int max = 0;

        /*
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int h = Math.min(height[i],height[j]);
                int w = j-i;
                max = Math.max(max,h*w);
            }
        }
        */

        int i=0,j=height.length-1;
        while(i<j){
            int h = Math.min(height[i],height[j]);
            int w = j-i;
            max = Math.max(max,h*w);
            if(height[i]<height[j]) i++;
            else if(height[i]>=height[j]) j--;
        }
        return max;
    }
}