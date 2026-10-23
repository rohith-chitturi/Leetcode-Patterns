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
    int preIndex=0;
    Map<Integer,Integer> inordermap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inordermap.put(inorder[i],i);
        }
        return build(preorder,0,inorder.length-1);
    }
    public TreeNode build(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootval=preorder[preIndex++];
        TreeNode root=new TreeNode(rootval);
        int id=inordermap.get(rootval);
        root.left=build(preorder,left,id-1);
        root.right=build(preorder,id+1,right);
        return root;
    }
}