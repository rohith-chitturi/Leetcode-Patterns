class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int[] rowCount=new int[m];
        int[] colCount=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int total=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int[] componentSize={0};
                    dfs(grid,i,j,visited,componentSize);
                    if(componentSize[0]>1){
                        total+=componentSize[0];
                    }
                }
            }
        }
        return total;
    }
    public void dfs(int[][] grid,int r,int c,boolean[][] visited,int[] size){
        visited[r][c]=true;
        size[0]++;
        for(int j=0;j<grid[0].length;j++){
            if(grid[r][j]==1 && !visited[r][j]){
                dfs(grid,r,j,visited,size);
            }
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][c]==1 && !visited[i][c]){
                dfs(grid,i,c,visited,size);
            }
        }
    }
}