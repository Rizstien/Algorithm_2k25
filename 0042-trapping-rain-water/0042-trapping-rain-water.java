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
        /*
        int total=0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
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
        */

        //Optimal Solution with 2 Ptrs - O(n) time and O(1) space
        
        int leftMax=0,rightMax=0,total=0;
        int left=0,right=height.length-1;

        while(left<right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                total = leftMax - height[left] > 0 ?
                    total + leftMax - height[left] : 
                    total;
                left++;
            }else if(height[right] <= height[left]){
                rightMax = Math.max(rightMax, height[right]);
                total = rightMax - height[right] > 0 ?
                    total + rightMax - height[right] : 
                    total;
                    right--;
            }
        }
        return total;
    }
}