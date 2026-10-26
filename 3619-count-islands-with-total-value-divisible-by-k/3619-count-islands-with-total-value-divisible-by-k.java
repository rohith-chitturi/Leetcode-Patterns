class Solution {
    int m,n;
    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    long[] state={0};
                    dfs(grid,i,j,state);
                    if(state[0]%k==0){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    void dfs(int[][] g,int i,int j,long[] state){
        if(i<0 || i>=m || j<0 || j>=n || g[i][j]==0){
            return;
        }
        state[0]+=g[i][j];
        g[i][j]=0;
        dfs(g,i+1,j,state);
        dfs(g,i-1,j,state);
        dfs(g,i,j+1,state);
        dfs(g,i,j-1,state);
    }
}