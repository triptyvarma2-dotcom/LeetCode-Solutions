class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        for(int i=0;i<n;i++){
            nums[i]=nums[i]*nums[i];
        }
        qs(nums,0,n-1);
        return nums;
    }
    public static void qs(int nums[],int low,int high){
        
        if(low<high){
            int p_index=fn(nums,low,high);
            qs(nums,low,p_index-1);
            qs(nums,p_index+1,high);
        }
    }
    public static int fn(int nums[],int low,int high){
        int pivot=nums[low];
        int i=low;
        int j=high;
        while(i<j){
            while(nums[i]<=pivot && i<high){
                i++;
            }
            while(nums[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[low];
        nums[low]=nums[j];
        nums[j]=temp;
        return j;
    }

}