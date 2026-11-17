import java.util.Arrays;
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                cost[i][j] = len; 
                for (int d = 1; d < len; d++) {
                    if (len % d == 0) {
                        int changes = 0;
                        for (int offset = 0; offset < d; offset++) {
                            int left = i + offset;
                            int right = j - (d - 1 - offset);
                            while (left < right) {
                                if (s.charAt(left) != s.charAt(right)) {
                                    changes++;
                                }
                                left += d;
                                right -= d;
                            }
                        }
                        cost[i][j] = Math.min(cost[i][j], changes);
                    }
                }
            }
        }
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) Arrays.fill(row, 1000);
        for (int i = 0; i < n; i++) {
            dp[1][i] = cost[0][i];
        }
        for (int p = 2; p <= k; p++) {
            for (int i = (p * 2) - 1; i < n; i++) {
                for (int prev = (p - 1) * 2 - 1; prev < i - 1; prev++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][prev] + cost[prev + 1][i]);
                }
            }
        }
        return dp[k][n - 1];
    }
}