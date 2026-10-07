class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int l = 0, r = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l == 0) {
                    r++;
                } else {
                    l--;
                }
            }
        }
        
        dfs(s, 0, l, r, res);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int index, int l, int r, Set<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String next = s.substring(0, i) + s.substring(i + 1);
                
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(next, i, l, r - 1, res);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(next, i, l - 1, r, res);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}