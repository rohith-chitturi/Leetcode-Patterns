class Solution {
    public int fib(int n) {
        // int[] arr=new int[n+1];
        // Arrays.fill(arr,-1);
        // if(n<=1){
        //     return n;
        // }
        // if(arr[n]!=-1){
        //     return arr[n];
        // }
        // return arr[n]=fib(n-1)+fib(n-2);//Till here it is DP with Memoization
        if(n<=1){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];//till here it DP with Tabulation
    }
}