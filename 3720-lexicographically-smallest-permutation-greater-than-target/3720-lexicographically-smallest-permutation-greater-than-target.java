class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        int n = s.length(), match = 0;
        while (match < n && count[target.charAt(match) - 'a'] > 0) {
            count[target.charAt(match++) - 'a']--;
        }
        for (int i = match; i >= 0; i--) {
            if (i < n) {
                for (int c = target.charAt(i) - 'a' + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        StringBuilder sb = new StringBuilder(target.substring(0, i));
                        sb.append((char) (c + 'a'));
                        count[c]--;
                        
                        for (int j = 0; j < 26; j++) {
                            while (count[j]-- > 0) sb.append((char) (j + 'a'));
                        }
                        return sb.toString();
                    }
                }
            }
            if (i > 0) count[target.charAt(i - 1) - 'a']++;
        }
        return "";
    }
}