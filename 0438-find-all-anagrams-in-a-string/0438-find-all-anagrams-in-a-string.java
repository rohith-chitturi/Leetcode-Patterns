class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int left=0;
        List<Integer> al=new ArrayList<>();
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        int n=s.length();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
            while((right-left+1)>p.length()){
                char lc=s.charAt(left);
                left++;
                map2.put(lc,map2.getOrDefault(lc,0)-1);
                if(map2.get(lc)==0){
                    map2.remove(lc);
                }
            } 
            if((right-left+1)==p.length()){
                if(map2.equals(map1)){
                    al.add(left);
                }
            }        
        }
        return al;
    }
}