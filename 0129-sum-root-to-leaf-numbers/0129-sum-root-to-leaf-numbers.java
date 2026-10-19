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
    int res=0;
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    // public int helper(TreeNode root,String s){
    //     if(root==null){
    //         return 0;
    //     }
    //     s+=root.val;
    //     if(root.left==null && root.right==null){
    //         return Integer.parseInt(s);
    //     }
    //     int ls=helper(root.left,s);
    //     int rs=helper(root.right,s);
    //     return ls+rs;
    // }
        public int helper(TreeNode root,int sum){
            if(root==null){
                return 0;
            }
            sum=sum*10+root.val;
            if(root.left==null && root.right==null){
                res+=sum;
            }
            helper(root.left,sum);
            helper(root.right,sum);
            return res;
        }
}