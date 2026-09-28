class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n!=m){
            return false;
        }
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(!map1.containsKey(ch1)){
                map1.put(ch1,ch2);
            }else{
                char c=map1.get(ch1);
                if(c!=ch2){
                    return false;
                }
            }
            if(!map2.containsKey(ch2)){
                map2.put(ch2,ch1);
            }else{
                char c1=map2.get(ch2);
                if(c1!=ch1){
                    return false;
                }
            }
        }
        return true;
    }
}