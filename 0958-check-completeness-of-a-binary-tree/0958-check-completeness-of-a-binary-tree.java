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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        boolean nullfound=false;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp==null){
                nullfound=true;
            }else{
                if(nullfound){
                    return false;
                }else{
                    q.offer(temp.left);
                    q.offer(temp.right);
                }
            }
        }
        return true;
    }
}