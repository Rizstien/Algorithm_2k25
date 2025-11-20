class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        if(m==0) {
            for(int i=0;i<n;i++)
                nums1[i] = nums2[i];
            return;
        }


        int[] result = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                result[k] = nums1[i];
                i++;
                k++;
            }else{
                result[k] = nums2[j];
                j++;
                k++;
            }
        }

        while(j<n){
            result[k++] = nums2[j++];
        }

        while(i<m){
            result[k++] = nums1[i++];
        }

        for(int l=0;l<m+n;l++){
            nums1[l] = result[l];
        }

        
        
    }
}