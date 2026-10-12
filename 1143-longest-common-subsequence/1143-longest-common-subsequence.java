class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for(int[] row:dp){
        Arrays.fill(row,-1);
        }
        return lcs(text1,text2,0,0,dp);
    }
    // public int lcs(String text1,String text2,int i,int j){
    //     if(i==text1.length()){
    //         return 0;
    //     }
    //     if(j==text2.length()){
    //         return 0;
    //     }
    //     char ch1=text1.charAt(i);
    //     char ch2=text2.charAt(j);
    //     int ans=0;
    //     if(ch1==ch2){
    //         ans= 1+lcs(text1,text2,i+1,j+1);
    //     }else{
    //         ans=Math.max(lcs(text1,text2,i+1,j),lcs(text1,text2,i,j+1));
    //     }
    //     return ans;
    // }TLE O(2^n) 
    public int lcs(String text1,String text2,int i,int j,int[][] dp){
        if(i==text1.length()){
            return 0;
        }
        if(j==text2.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        char ch1=text1.charAt(i);
        char ch2=text2.charAt(j);
        int ans=0;
        if(ch1==ch2){
            ans= 1+lcs(text1,text2,i+1,j+1,dp);
        }else{
            ans=Math.max(lcs(text1,text2,i+1,j,dp),lcs(text1,text2,i,j+1,dp));
        }
        return dp[i][j]=ans;
    }
}