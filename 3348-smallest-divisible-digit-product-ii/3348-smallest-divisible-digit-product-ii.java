class Solution {
    int[][] dp = new int[60][40];
    int getMin(int p2, int p3) {
        p2 = Math.max(0, p2); 
        p3 = Math.max(0, p3);
        if (p2 == 0 && p3 == 0) return 0;
        if (dp[p2][p3] != 0) return dp[p2][p3];
        int res = 100000;
        if (p2 > 0) res = Math.min(res, getMin(p2 - 3, p3)); 
        if (p3 > 0) res = Math.min(res, getMin(p2, p3 - 2)); 
        res = Math.min(res, getMin(p2 - 1, p3 - 1));
        return dp[p2][p3] = 1 + res;
    }
    public String smallestNumber(String num, long t) {
        int[] req = new int[8];
        for (int p : new int[]{2, 3, 5, 7}) {
            while (t % p == 0) { req[p]++; t /= p; }
        }
        if (t > 1) return "-1";
        int n = num.length();
        int z = num.indexOf('0');
        if (z == -1) z = n - 1;
        int[][] pref = new int[n + 1][8];
        pref[0] = req.clone();
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i].clone();
            sub(pref[i + 1], num.charAt(i) - '0');
        }
        if (num.indexOf('0') == -1) {
            int[] r = pref[n];
            if (r[2] <= 0 && r[3] <= 0 && r[5] <= 0 && r[7] <= 0) return num;
        }
        for (int i = z; i >= 0; i--) {
            int[] r = pref[i]; 
            for (int d = num.charAt(i) - '0' + 1; d <= 9; d++) {
                int[] nr = r.clone();
                sub(nr, d);
                if (Math.max(0, nr[5]) + Math.max(0, nr[7]) + getMin(nr[2], nr[3]) <= n - 1 - i) {
                    return build(num.substring(0, i) + d, n - 1 - i, nr);
                }
            }
        }
        for (int len = n + 1; ; len++) {
            if (Math.max(0, req[5]) + Math.max(0, req[7]) + getMin(req[2], req[3]) <= len) {
                return build("", len, req);
            }
        }
    }
     void sub(int[] r, int v) {
        if (v <= 0) return;
        while (v % 2 == 0) { r[2]--; v /= 2; }
        while (v % 3 == 0) { r[3]--; v /= 3; }
        while (v % 5 == 0) { r[5]--; v /= 5; }
        while (v % 7 == 0) { r[7]--; v /= 7; }
    }
    String build(String prefix, int rem, int[] r) {
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < rem; i++) {
            for (int d = 1; d <= 9; d++) {
                int[] nr = r.clone();
                sub(nr, d);
                if (Math.max(0, nr[5]) + Math.max(0, nr[7]) + getMin(nr[2], nr[3]) <= rem - 1 - i) {
                    sb.append(d);
                    r = nr;
                    break;
                }
            }
        }
        return sb.toString();
    }
}