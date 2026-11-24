class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    public boolean valid(int i,int j,int n,int m){
        if(i<0 || j>=m ||i>=n|| j<0){
            return false;
        }
        return true;
    }
    public void dfs(char[][] grid,int n,int m,int i,int j,boolean[][] vis){
        vis[i][j]=true;
        for(int k=0;k<4;k++){
            int row=i+x[k];
            int col=j+y[k];
            if(valid(row,col,n,m) && grid[row][col]=='1'&&vis[row][col]==false){
                dfs(grid,n,m,row,col,vis);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int res=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    dfs(grid,n,m,i,j,vis);
                    res++;
                }
            }
        }
        return res;
    }
}