class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int me=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                me=Math.max(cnt,me);
            }else{
                cnt=0;
            }
        }
        return me;
    }
}