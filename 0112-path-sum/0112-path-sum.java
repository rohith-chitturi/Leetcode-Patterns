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
    boolean res=false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if(root == null){
        //     return false;
        // }
        // targetSum=targetSum-root.val;
        // if(root.left==null && root.right==null && targetSum==0){
        //     return true;
        // }
        // return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
        int sum=0;
        return helper(root,sum,targetSum);
    }
    public boolean helper(TreeNode root,int sum,int targetSum){
        if(root==null){
            return false;
        }
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res=true;
            }
        }
        helper(root.left,sum,targetSum);
        helper(root.right,sum,targetSum);
        return res;
    }
}