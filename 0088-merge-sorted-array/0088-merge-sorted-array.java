class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // m= nums1.length;
       // n=nums2.length;
        int temp[]=new int[m+n];
        int k=0;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                temp[k]=nums1[i];
                i++;
            }else{
                temp[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
            temp[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            temp[k]=nums2[j];
            j++;
            k++;
        }
        for(int l=0;l<nums1.length;l++){
            nums1[l]=temp[l];
        }
    }
}