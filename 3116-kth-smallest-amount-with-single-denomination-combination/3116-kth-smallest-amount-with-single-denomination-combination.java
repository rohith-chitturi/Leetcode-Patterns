class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        
        long left = 1;
        long right = minCoin * k; 
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private long count(long amount, int[] coins) {
        long total = 0;
        int n = coins.length;
        
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int setBits = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    setBits++;
                }
            }
            
            if (setBits % 2 == 1) {
                total += amount / lcm;
            } else {
                total -= amount / lcm;
            }
        }
        
        return total;
    }
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}