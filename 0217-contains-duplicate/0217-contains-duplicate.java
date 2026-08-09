class Solution {
    int count=0;
    public boolean containsDuplicate(int[] nums) {
        
        HashMap<Integer,Integer> fre=new HashMap<>();
        for(int x: nums){
            if(fre.containsKey(x)){
                fre.put(x,fre.get(x)+1);
                count++;
            }else{
                fre.put(x,1);
            }
        }
        if(count>0)
        return true;
        return false;
        
    }
}