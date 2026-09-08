class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int p_sum=0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            p_sum=p_sum+ nums[i];

            if(map.containsKey(p_sum-k)){
                count = count + map.get(p_sum-k);
            }
            map.put(p_sum,map.getOrDefault(p_sum,0) + 1);
        }
        return count;
    }
}