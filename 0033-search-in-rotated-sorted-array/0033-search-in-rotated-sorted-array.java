class Solution {
    public int search(int[] nums, int target) {
        
        int low=0;
        int high=nums.length-1;
        return bs(nums,low,high,target);
    }
    public int bs(int nums[],int low,int high,int target){
        int mid=(high+low)/2;
        if(high<low)
        return -1;
        if(target==nums[mid]){
            return mid;
        }
        if(nums[low]<=nums[mid]){
            if(target>=nums[low]&& target<nums[mid]){
            return bs(nums,low,mid-1,target);
        }else{
            return bs(nums,mid+1,high,target);
        }
        
    }else{
        if(target>nums[mid]&& target<=nums[high]){
            return bs(nums,mid+1,high,target);
        }else{
            return bs(nums,low,mid-1,target);
        }
    }
}
}