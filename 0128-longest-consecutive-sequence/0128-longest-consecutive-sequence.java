class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        if(nums.length==0){
            return 0;
        }
        for(int x: nums){
            set.add(x);
        }
       int longest=0;
        for(int num : set){
            if(!set.contains(num-1)){
                int cur=num;
                int cnt=1;
                while(set.contains(cur+1)){
                    cur++;
                    cnt++;
                }
                longest=Math.max(longest,cnt);

    
            }
        }
        return longest;
    }
}