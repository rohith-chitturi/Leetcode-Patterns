import java.util.*;
class Solution {
    private List<List<Integer>> originalChildren;
    private List<List<Integer>> finalChildren;
    private String s;
    private int[] answer;
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.originalChildren = new ArrayList<>(n);
        this.finalChildren = new ArrayList<>(n);
        this.answer = new int[n];
        for (int i = 0; i < n; i++) {
            originalChildren.add(new ArrayList<>());
            finalChildren.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            originalChildren.get(parent[i]).add(i);
        }
        int[] closestAncestor = new int[26];
        Arrays.fill(closestAncestor, -1);
        buildFinalTree(0, parent, closestAncestor);
        computeSubtreeSizes(0);
        return answer;
    }
    private void buildFinalTree(int node, int[] parent, int[] closestAncestor) {
        int charIdx = s.charAt(node) - 'a';
        int prevAncestor = closestAncestor[charIdx];
        int targetParent = (node != 0 && prevAncestor != -1) ? prevAncestor : parent[node];
        if (node != 0) {
            finalChildren.get(targetParent).add(node);
        }
        closestAncestor[charIdx] = node;
        for (int child : originalChildren.get(node)) {
            buildFinalTree(child, parent, closestAncestor);
        }
        closestAncestor[charIdx] = prevAncestor;
    }
    private int computeSubtreeSizes(int node) {
        int size = 1;
        for (int child : finalChildren.get(node)) {
            size += computeSubtreeSizes(child);
        }
        answer[node] = size;
        return size;
    }
}