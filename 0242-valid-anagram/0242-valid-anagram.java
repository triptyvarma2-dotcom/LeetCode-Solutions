class Solution {
    public boolean isAnagram(String s, String t) {
         HashMap<Character,Integer> str1=new HashMap<>();
        for(char x: s.toCharArray()){
            if(str1.containsKey(x)){
                str1.put(x,str1.get(x)+1);
                
            }else{
               str1.put(x,1);
            }
        }
        HashMap<Character,Integer> str2=new HashMap<>();
        for(char i: t.toCharArray()){
            if(str2.containsKey(i)){
                str2.put(i,str2.get(i)+1);
                
            }else{
               str2.put(i,1);
            }
        }
        if(str1.equals(str2))
        return true;
        return false;
    }
}