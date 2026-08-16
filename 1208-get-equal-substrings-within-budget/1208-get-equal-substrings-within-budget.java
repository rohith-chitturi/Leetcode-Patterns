class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int left=0;
        int cost=0;
        int max=0;
        for(int right=0;right<n;right++){
            cost+=Math.abs(s.charAt(right)-t.charAt(right));
            while(cost>maxCost){
                cost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            if(cost<=maxCost){
                int len=right-left+1;
                max=Math.max(len,max);
            }
        }
        return max;
    }
}