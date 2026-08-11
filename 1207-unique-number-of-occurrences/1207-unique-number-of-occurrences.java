class Solution {
    public boolean uniqueOccurrences(int[] arr) {
      
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int x : arr){
            if(h.containsKey(x)){
                h.put(x,h.get(x)+1);
            }else{
                h.put(x,1);
            }
        }
        HashSet<Integer> hs=new HashSet<>();
        for(int i:h.values()){
            if(hs.contains(i)){
              return false;
            }else{
              hs.add(i);
        }
    }
        return true;
    }
}