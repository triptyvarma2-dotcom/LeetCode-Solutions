// class Solution {
//     public int findPeakElement(int[] nums) {
//         int low =0;
//         int high=nums.length-1;
//         int peak=fun(nums,low,high);
//         return peak;
//     }
//     public static int fun(int nums[],int low,int high){
//          low=0;
//          high=nums.length-1;
//         if(low<high){
//             return -1;
//         }else {
//             int mid=low+(high-low)/2;
//             if((mid!=0 || mid!=nums.length-1) && nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
//                 return mid;
//             }
//             else if((mid==0 && nums[mid]>nums[mid+1]) ||(mid==nums.length-1 && nums[mid]>nums[mid-1])){
//                 return mid;
//             }
//             else{          
//             fun(nums,low,mid-1);
//             fun(nums,mid+1,high);
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If the element to the right is greater, a peak must exist on the right side
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                // Otherwise, a peak exists on the left side (including mid)
                high = mid;
            }
        }

        // When low == high, we have narrowed down to a peak element
        return low;
    }
}