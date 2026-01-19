class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] result = new int[nums1.length+nums2.length];

        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                result[k++] = nums1[i++];
            }else{
                result[k++] = nums2[j++];
            }
        }

        while(i<nums1.length){
            result[k++] = nums1[i++];
        }

        while(j<nums2.length){
            result[k++] = nums2[j++];
        }

        i=0;
        j=result.length-1;

        while(i<j){
            i++;
            j--;
        }
        if(i==j) return result[j];
        else return (double) (result[i]+result[j])/2;
    }
}