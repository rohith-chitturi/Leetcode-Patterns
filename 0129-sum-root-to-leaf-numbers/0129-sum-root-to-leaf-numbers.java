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
    public int sumNumbers(TreeNode root) {
        return helper(root,"");
    }
    public int helper(TreeNode root,String s){
        if(root==null){
            return 0;
        }
        s+=root.val;
        if(root.left==null && root.right==null){
            return Integer.parseInt(s);
        }
        int ls=helper(root.left,s);
        int rs=helper(root.right,s);
        return ls+rs;
    }
}