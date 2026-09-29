class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String> set=new HashSet<>(wordDict);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String word=s.substring(j,i);
                if(dp[j] && set.contains(word)){
                    dp[i]=true;
                }
            }
        }
        return dp[n];
    }
}