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
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> diary=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum=0;
        helper(root,sum,targetSum);
        return res;
    }
    public void helper(TreeNode root,int sum,int targetSum){
        if(root==null){
            return;
        }
        sum+=root.val;
        diary.add(root.val);
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                res.add(new ArrayList<>(diary));
            }
        }
        helper(root.left,sum,targetSum);
        helper(root.right,sum,targetSum);
        diary.remove(diary.size()-1);
    }
}