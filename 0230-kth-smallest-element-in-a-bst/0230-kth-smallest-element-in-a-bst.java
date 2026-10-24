/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //List<Integer> al=new ArrayList<>();
    Stack<TreeNode> st=new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
    //     inorder(root);
    //     return al.get(k-1);
    // }
    // public void inorder(TreeNode root){
    //     if(root==null){
    //         return;
    //     }
    //     inorder(root.left);
    //     al.add(root.val);
    //     inorder(root.right);
    while(true){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
        root=st.pop();
        k--;
        if(k==0){
            return root.val;
        }
        root=root.right;
    }
    }
}