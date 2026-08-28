class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int oddCount = 0;
        for (int c : count) {
            if (c % 2 != 0) {
                oddCount++;
            }
        }
        if (oddCount > 1) {
            return "";
        }
        char[] res = new char[s.length()];
        if (dfs(0, false, count, res, target)) {
            return new String(res);
        }
        return "";
    }
    private boolean dfs(int i, boolean isGreater, int[] count, char[] res, String target) {
        int n = res.length;
        if (i == n / 2) {
            if (n % 2 != 0) {
                for (int c = 0; c < 26; c++) {
                    if (count[c] > 0) {
                        boolean nextGreater = isGreater || (c + 'a' > target.charAt(i));
                        if (!isGreater && c + 'a' < target.charAt(i)) {
                            continue;
                        }
                        res[i] = (char) (c + 'a');
                        if (nextGreater) {
                            return true;
                        }
                        return new String(res).compareTo(target) > 0;
                    }
                }
                return false;
            } else {
                if (isGreater) {
                    return true;
                }
                return new String(res).compareTo(target) > 0;
            }
        }
        for (int c = 0; c < 26; c++) {
            if (count[c] >= 2) {
                boolean nextGreater = isGreater || (c + 'a' > target.charAt(i));
                if (!isGreater && c + 'a' < target.charAt(i)) {
                    continue;
                }
                res[i] = (char) (c + 'a');
                res[n - 1 - i] = (char) (c + 'a');
                count[c] -= 2;
                
                if (dfs(i + 1, nextGreater, count, res, target)) {
                    return true;
                }
                count[c] += 2;
            }
        }
        return false;
    }
}