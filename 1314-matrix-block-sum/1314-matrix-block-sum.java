class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] prefix=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 prefix[i + 1][j + 1] =mat[i][j]+ prefix[i][j + 1]+ prefix[i + 1][j]- prefix[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top = Math.max(0, i - k);
                int bottom = Math.min(m - 1, i + k);
                int left = Math.max(0, j - k);
                int right = Math.min(n - 1, j + k);
                ans[i][j] =prefix[bottom + 1][right + 1]- prefix[top][right + 1]- prefix[bottom + 1][left]+ prefix[top][left];
            }
        }
        return ans;
    }
}