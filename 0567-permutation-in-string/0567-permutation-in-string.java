class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left=0;
        int n=s2.length();
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(int right=0;right<n;right++){
            char ch=s2.charAt(right);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            if((right-left+1)>s1.length()){
                char leftchar=s2.charAt(left);
                map2.put(leftchar,map2.getOrDefault(leftchar,0)-1);
                left++;
                if(map2.get(leftchar)==0){
                    map2.remove(leftchar);
                }
            }
            if((right-left+1)==s1.length()){
                if(map2.equals(map1)){
                    return true;
                }
            }
        }
        return false;
    }
}