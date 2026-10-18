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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        findTarget(root.left,k);
        al.add(root.val);
        findTarget(root.right,k);
        int low=0;
        int high=al.size()-1;
        while(low<high){
            int v1=al.get(low);
            int v2=al.get(high);
            if(v1+v2==k){
                return true;
            }else if(v1+v2<k){
                low++;
            }else{
                high--;
            }
        }
        return false;
    }
}