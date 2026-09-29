class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int len = m + n - 1;
        if (len % 2 == 1) {
            return false;
        }
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        boolean[][][] dp = new boolean[m][n][len + 1];
        dp[0][0][1] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                for (int balance = 0; balance <= len; balance++) {
                    int newBalance;
                    if (grid[i][j] == '(') {
                        newBalance = balance + 1;
                    } else {
                        newBalance = balance - 1;
                    }
                    if (newBalance < 0) {
                        continue;
                    }
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
        
    }
}