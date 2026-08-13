class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int n=s.length();
        int maxFreq=0;
        int max=Integer.MIN_VALUE;
        Map<Character,Integer> map=new HashMap<>();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
            int len=right-left+1;
            int diff=len-maxFreq;
            while(diff>k){
                char leftchar=s.charAt(left);
                map.put(leftchar,map.getOrDefault(leftchar,0)-1);
                left++;
                diff--;
            }
            max=Math.max(max,right-left+1);
        }
        return max;
    }
}