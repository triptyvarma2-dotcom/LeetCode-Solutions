class Solution {
    int sum=0;
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int x :nums){
            if(h.containsKey(x)){
                h.put(x,h.get(x)+1);
            }else{
                h.put(x,1);
            }
        }
        for(int i :h.keySet()){
            if(h.get(i)==1)
        
        sum= sum+i;
        }
        return sum;
    }
}