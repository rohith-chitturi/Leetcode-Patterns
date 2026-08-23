class Solution {
    public int climbStairs(int n) {
       int[] dp=new int[n+1];
       Arrays.fill(dp,-1);
       return dynamicprogramming(n,dp); 
    }
    public int dynamicprogramming(int n,int[] dp){
        if(n==1 || n==2) return n;
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=dynamicprogramming(n-1,dp)+dynamicprogramming(n-2,dp);
    }
}