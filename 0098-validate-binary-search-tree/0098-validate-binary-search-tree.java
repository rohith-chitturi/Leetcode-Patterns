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
    List<Integer> al=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        isValidBST(root.left);
        al.add(root.val);
        isValidBST(root.right);
        for(int i=1;i<al.size();i++){
            if(al.get(i)<=al.get(i-1)){
                return false;
            }
        }
        return true;//this is brute force approach 
    }
}