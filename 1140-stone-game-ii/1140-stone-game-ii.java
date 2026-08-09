class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n+1];
        int[] suf=new int[n];
        suf[n-1]=piles[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]+piles[i];
        }
        return dfs(0,1,piles,suf,dp);
    }
    private int dfs(int i,int m,int[] piles,int[] suf,int[][] memo){
        if(i>=piles.length){
            return 0;
        }
        if(i+2*m>=piles.length){
            return suf[i];
        }
        if(memo[i][m]!=0){
            return memo[i][m];
        }
        int res=0;
        for(int x=1;x<=2*m;x++){
            res=Math.max(res,suf[i]-dfs(i+x,Math.max(m,x),piles,suf,memo));
        }
        return memo[i][m]=res;
    }
}