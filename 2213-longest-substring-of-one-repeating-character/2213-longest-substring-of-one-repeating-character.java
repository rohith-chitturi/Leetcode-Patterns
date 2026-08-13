class Solution {
    class Node {
        int maxLen;
        int prefLen;
        int suffLen;
        char prefChar;
        char suffChar;
        int size;
        public Node(char c) {
            maxLen = prefLen = suffLen = 1;
            prefChar = suffChar = c;
            size = 1;
        }
        public Node() {}
    }
    Node[] tree;
    String str;
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        this.str = s;
        int n = s.length();
        tree = new Node[4 * n];
        build(1, 0, n - 1);
        int k = queryCharacters.length();
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].maxLen;
        }
        return ans;
    }
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        Node res = new Node();
        res.size = left.size + right.size;
        res.prefChar = left.prefChar;
        res.suffChar = right.suffChar;
        res.prefLen = left.prefLen;
        if (left.prefLen == left.size && left.prefChar == right.prefChar) {
            res.prefLen += right.prefLen;
        }
        res.suffLen = right.suffLen;
        if (right.suffLen == right.size && right.suffChar == left.suffChar) {
            res.suffLen += left.suffLen;
        }
        res.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.suffChar == right.prefChar) {
            res.maxLen = Math.max(res.maxLen, left.suffLen + right.prefLen);
        }
        return res;
    }
    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(str.charAt(start));
            return;
        }
        int mid = start + (end - start) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node] = new Node(c);
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, c);
        } else {
            update(2 * node + 1, mid + 1, end, idx, c);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
}