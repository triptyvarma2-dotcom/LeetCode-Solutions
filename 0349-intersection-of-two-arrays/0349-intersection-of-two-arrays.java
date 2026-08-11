class Solution {
    int i=0;
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int x:nums1){
            if(h.containsKey(x)){
                h.put(x,h.get(x)+1);
            }else{
                h.put(x,1);
            }
        }
        HashSet <Integer> hs = new HashSet<>();
        for( int i:nums2){
            if(h.containsKey(i)){
                hs.add(i);

            }

        }
        int[]ans= new int[hs.size()];
        int j=0;
        for(int x: hs){
            ans[j]=x;
            j++;
        }
        return ans;
    }
}