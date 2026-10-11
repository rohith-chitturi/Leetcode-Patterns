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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        boolean lefttoright=true;
        if(root==null){
            return res;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> temp=new ArrayList<>();
            while(levelsize-->0){
                TreeNode t=q.poll();
                if(lefttoright){
                    temp.add(t.val);
                }else{
                    temp.add(0,t.val);
                }
                if(t.left!=null){
                    q.offer(t.left);
                }
                if(t.right!=null){
                    q.offer(t.right);
                }
            }
            res.add(temp);
            lefttoright=!lefttoright;
        }
        return res;
    }
}