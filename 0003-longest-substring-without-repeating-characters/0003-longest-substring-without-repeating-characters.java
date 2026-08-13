class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int n=s.length();
        int max=0;
        Set<Character> hs=new HashSet<>();
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            while(hs.contains(ch)){
                hs.remove(s.charAt(left));
                left++;
            }
            hs.add(ch);
            int len=right-left+1;
            max=Math.max(max,len);
        }
        return max;
    }
}