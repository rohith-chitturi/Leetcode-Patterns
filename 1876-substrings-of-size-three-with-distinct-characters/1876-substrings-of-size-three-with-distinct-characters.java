class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(right-left+1>3){
                char leftch=s.charAt(left);
                map.put(leftch,map.getOrDefault(leftch,0)-1);
                if(map.get(leftch)==0){
                    map.remove(leftch);
                }
                left++;
            }
            if(right-left+1==3 && map.size()==3){
                count++;
            }
        }
        return count;
    }
}