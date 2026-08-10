class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> hm1 = new HashMap<>();
        for(char x: ransomNote.toCharArray()){
            if(hm1.containsKey(x)){
                hm1.put(x,hm1.get(x)+1);
            }else{
                hm1.put(x,1);
            }
        }
          HashMap<Character,Integer> hm2 = new HashMap<>();
        for(char c: magazine.toCharArray()){
            if(hm2.containsKey(c)){
                hm2.put(c,hm2.get(c)+1);
            }else{
                hm2.put(c,1);
            }
        }
        for(char i:hm1.keySet()){
            if(!hm2.containsKey(i)|| hm2.get(i)<hm1.get(i)){
                return false;
            }
        }
        return true;
    }
}