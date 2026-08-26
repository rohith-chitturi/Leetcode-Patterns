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
    List<String> res=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        path(root,"");
        return res;
    }
    public void path(TreeNode root,String current){
        if(root==null){
            return;
        }
        if(current.equals("")){
            current=current+root.val;
        }else{
            current=current+"->"+root.val;
        }
        if(root.left==null && root.right==null){
            res.add(current);
            return;
        }
        path(root.left,current);
        path(root.right,current);
    }
}