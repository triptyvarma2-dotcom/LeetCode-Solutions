class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=maxElement(piles);
        while(low<=high){
            int mid=low+(high-low)/2;
            int req_time=findK(piles,mid);
            if(req_time<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int findK(int piles[],int k){
        int total_hrs=0;
        for(int i=0;i<piles.length;i++){
            total_hrs += Math.ceil((double)piles[i]/k);
        }
        return total_hrs;
    }
    public int maxElement(int piles[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }
        return max;
    }
}