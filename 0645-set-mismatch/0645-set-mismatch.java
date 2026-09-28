class Solution {
    public int[] findErrorNums(int[] nums) {
        long n=nums.length;
        long sN=(n*(n+1))/2;
        long s2N=(n*(n+1)*(2*n+1))/6;
        long s=0;
        long s2=0;
        for(int i=0;i<n;i++){
            s=s+nums[i];
            s2=s2+ ((long)nums[i]*(long)nums[i]);
        }
        long val1=s-sN;
        long val2=s2-s2N;
        val2=val2/val1;
        long x=(val1+val2)/2;
        long y=(x-val1);
        
        return new int[]{(int)x,(int)y};
    }
}