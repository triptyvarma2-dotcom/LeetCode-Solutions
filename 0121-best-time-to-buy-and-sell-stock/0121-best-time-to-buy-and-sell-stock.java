class Solution {
    public int maxProfit(int[] prices) {
        int bp=Integer.MAX_VALUE;
        int mp=0;
        for(int i=0; i<prices.length;i++){
            if(bp<prices[i]){
                int profit= prices[i]-bp;
                if(profit>mp){
                    mp=profit;
                }
                //mp=Math.max(mp,profit);
            }else{
                bp=prices[i];
            }
        }
        return mp;
    }
}