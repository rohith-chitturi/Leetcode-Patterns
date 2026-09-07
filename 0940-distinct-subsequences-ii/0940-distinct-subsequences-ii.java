class Solution {
    public int distinctSubseqII(String s) {
       int MOD=1_000_000_007;
       int n=s.length();
       long[] dp=new long[n+1];
       long[] last=new long[26];
       dp[0]=1;
       for(int i=1;i<=n;i++){
        int c=s.charAt(i-1)-'a';
        long newCount=(2*dp[i-1])%MOD;
        newCount=(newCount-last[c]+MOD)%MOD;
        dp[i]=newCount;
        last[c]=dp[i-1];
       } 
       return (int)((dp[n]-1+MOD)%MOD);
    }
}