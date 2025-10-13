class Solution {
    public int trap(int[] height) {

    // at any given point check hMax = Min(LeftMaxHeight, RightMaxHeight)
    //  Trap water at any given point = hMax - currentHeight

        //B.F approach
        /*
        int total=0;
        for(int curr=0;curr<height.length;curr++){
            int leftMaxHeight=0,rightMaxHeight=0;
            for(int left = curr;left>=0;left--){
                leftMaxHeight = Math.max(leftMaxHeight,height[left]);
            }
            for(int right = curr;right<height.length;right++){
                rightMaxHeight = Math.max(rightMaxHeight,height[right]);
            }
            total = Math.min(rightMaxHeight, leftMaxHeight) 
                    - height[curr]>0?
                    total+Math.min(rightMaxHeight, leftMaxHeight) 
                    - height[curr] : 
                    total;
        }
        
        return total;
        */

        //Single Pass approach
        int total=0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        //int[] total = new int[height.length];
        
        int leftMaxHeight=0,rightMaxHeight=0,water=0;
        for(int left = height.length-1;left>=0;left--){
            leftMaxHeight = Math.max(leftMaxHeight,height[left]);
            leftMax[left] = leftMaxHeight;
        }

        for(int right = 0;right<height.length;right++){
            rightMaxHeight = Math.max(rightMaxHeight,height[right]);
            rightMax[right] = rightMaxHeight;
        }

        for(int i = 0;i<height.length;i++){
            water = Math.min(rightMax[i],leftMax[i]) - height[i];
            total += water;
        }
        return total;
    }
}