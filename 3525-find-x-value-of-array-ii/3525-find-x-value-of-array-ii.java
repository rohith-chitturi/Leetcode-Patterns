class Solution {
    class Node {
        int prod;
        int[] count;
        Node(int k) {
            count = new int[k];
        }
    }
    Node[] tree;
    int n;
    int K;
    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;
        Node res = new Node(K);
        res.prod = (left.prod * right.prod) % K;
        for (int i = 0; i < K; i++) {
            res.count[i] += left.count[i];
        }
        
        for (int i = 0; i < K; i++) {
            res.count[(left.prod * i) % K] += right.count[i];
        }
        return res;
    }
    private void build(int node, int start, int end, int[] nums) {
        if (start == end) {
            tree[node] = new Node(K);
            int val = nums[start] % K;
            tree[node].prod = val;
            tree[node].count[val] = 1;
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, nums);
        build(2 * node + 1, mid + 1, end, nums);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            int v = val % K;
            tree[node] = new Node(K);
            tree[node].prod = v;
            tree[node].count[v] = 1;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }
    private Node query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return null;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        Node left = query(2 * node, start, mid, l, r);
        Node right = query(2 * node + 1, mid + 1, end, l, r);
        return merge(left, right);
    }
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.K = k;
        this.tree = new Node[4 * n];
        build(1, 0, n - 1, nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            update(1, 0, n - 1, index, value);
            Node res = query(1, 0, n - 1, start, n - 1);
            result[i] = res != null ? res.count[x] : 0;
        }
        return result;
    }
}