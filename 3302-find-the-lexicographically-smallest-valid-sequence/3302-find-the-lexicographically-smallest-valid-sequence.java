class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] suf = new int[m + 1];
        for (int i = m - 1, j = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = n - 1 - j;
        }
        int[] ans = new int[n];
        boolean changed = false;
        int j = 0;
        for (int i = 0; i < m && j < n; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } else if (!changed && suf[i + 1] >= n - 1 - j) {
                ans[j++] = i;
                changed = true;
            }
        }
        return j == n ? ans : new int[0];
    }
}