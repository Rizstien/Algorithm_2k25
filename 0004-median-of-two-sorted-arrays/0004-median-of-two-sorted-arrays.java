class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = mergesortedArrays(nums1, nums2);
        int size = result.length;
        int start = 0, end = size-1;
        float mid = start + (end-start)/2;
        if(size%2 == 0){
            double first = (double) result[size/2-1];
            double second = (double) result[size/2];
            return (double) (first+second)/2;
        }else{
            return result[(int) Math.floor(mid)];
        }

    }

    public int[] mergesortedArrays(int nums1[], int nums2[]){
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[n+m];

        int i=0,j=0,k=0;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                result[k] = nums1[i];
                i++;k++;
            }else{
                result[k] = nums2[j];
                j++;k++;
            }
        }

        while(i<n){
            result[k] = nums1[i];
            i++;k++;
        }

        while(j<m){
            result[k] = nums2[j];
            j++;k++;
        }

        return result;
    }
}