class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] ans = new long[k];
        long[] dp = new long[k];
        for (int num : nums) {
            num %= k;
            long[] newDp = new long[k];
            newDp[num]++;
            for (int r = 0; r < k; r++) {
                int newRemainder = (r * num) % k;
                newDp[newRemainder] += dp[r];
            }
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }
            dp = newDp;
        }
        return ans;
    }
}