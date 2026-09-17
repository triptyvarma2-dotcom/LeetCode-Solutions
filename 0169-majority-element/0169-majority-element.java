class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int maj_el=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                cnt=1;
                maj_el= nums[i];
            }
            else if(nums[i]==maj_el){
                cnt++;
            }else{
                cnt--;
            }
        }
        return maj_el;
    }
    
}