import java .util.Arrays;
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(nums[j]!= nums[i]){
                nums[i+1]= nums[j];
                i++;
            }
        }
        
        System.out.println(Arrays.toString(nums));
        
        return i+1;
    }
    
}