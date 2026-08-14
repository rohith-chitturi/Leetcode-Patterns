class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int max=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2){
                char leftchar=s.charAt(left);
                map.put(leftchar,map.getOrDefault(leftchar,0)-1);
                left++;
            }
            int len=right-left+1;
            max=Math.max(max,len);
        }
        return max;
    }
}