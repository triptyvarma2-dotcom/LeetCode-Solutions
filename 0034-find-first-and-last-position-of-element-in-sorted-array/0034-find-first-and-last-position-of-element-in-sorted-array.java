class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i=lB(nums,target);
        if(i==nums.length || nums[i]!=target){
        return new int[] {-1,-1};
        }
        return new int[] {i,uB(nums,target)-1};
        
    }
    public int lB(int nums[],int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int uB(int nums[],int target){
        int n=nums.length;
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>target){
                
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}