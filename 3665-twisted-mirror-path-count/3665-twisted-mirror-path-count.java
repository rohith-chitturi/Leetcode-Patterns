class Solution {
    int m,n;
    int[][][] jumpTarget;
    int[][] grid;
    public int uniquePaths(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        jumpTarget=new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                jumpTarget[i][j][0]=-2;
                jumpTarget[i][j][1]=-2;
            }
        }
        int[][] dp=new int[m][n];
        dp[0][0]=1;
        int MOD=1000000007;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]>0){
                    int rightDest=getJump(i,j+1,0);
                    if(rightDest>=0){
                        int r=rightDest/n;
                        int c=rightDest%n;
                        dp[r][c]=(dp[r][c]+dp[i][j])%MOD;
                    }
                    int downDest=getJump(i+1,j,1);
                    if(downDest>=0){
                        int r=downDest/n;
                        int c=downDest%n;
                        dp[r][c]=(dp[r][c]+dp[i][j])%MOD;
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
    private int getJump(int r,int c,int dir){
        if(r>=m || c>=n) return -1;
        if(grid[r][c]==0) return r*n+c;
        if(jumpTarget[r][c][dir]!=-2){
            return jumpTarget[r][c][dir];
        }
        int res;
        if(dir==0){
            res=getJump(r+1,c,1);
        }else{
            res=getJump(r,c+1,0);
        }
        jumpTarget[r][c][dir]=res;
        return res;
    }
}