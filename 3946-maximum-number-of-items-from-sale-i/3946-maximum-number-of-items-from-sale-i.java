import java.util.Arrays;
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        for (int[] item : items) {
            if (item[0] > maxFactor) {
                maxFactor = item[0];
            }
        }
        int[] freeCount = new int[n];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            int count = 0;
            for (int mult = f; mult <= maxFactor; mult += f) {
                for (int j = 0; j < n; j++) {
                    if (j != i && items[j][0] == mult) {
                        count++;
                    }
                }
            }
            freeCount[i] = count;
        }
        final int NEG_INF = Integer.MIN_VALUE / 4;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG_INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstGain = 1 + freeCount[i];
            int[] next = Arrays.copyOf(dp, budget + 1);
            for (int b = 0; b <= budget; b++) {
                if (dp[b] == NEG_INF) {
                    continue;
                }
                if (b + price <= budget) {
                    next[b + price] = Math.max(next[b + price], dp[b] + firstGain);
                }
            }
            for (int b = price; b <= budget; b++) {
                if (next[b - price] != NEG_INF) {
                    next[b] = Math.max(next[b], next[b - price] + 1);
                }
            }
            dp = next;
        }
        int ans = 0;
        for (int val : dp) {
            if (val > ans) {
                ans = val;
            }
        }
        return ans;
    }
}