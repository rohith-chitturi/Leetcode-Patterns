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
    List<TreeNode> al=new ArrayList<>();
    int wrongs=0;
    TreeNode wrong1first=null,wrong1second=null,wrong2first=null,wrong2second=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        for(int i=0;i<al.size()-1;i++){
            if(al.get(i).val>al.get(i+1).val){
                if(wrongs==0){
                    wrong1first=al.get(i);
                    wrong1second=al.get(i+1);
                    wrongs++;
                }else{
                    wrong2first=al.get(i);
                    wrong2second=al.get(i+1);
                    wrongs++;
                }
            }
        }
        if(wrongs==1){
            swap(wrong1first,wrong1second);
        }else{
            swap(wrong1first,wrong2second);
        }
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        al.add(root);
        inorder(root.right);
    }
    public void swap(TreeNode a,TreeNode b){
        int temp=a.val;
        a.val=b.val;
        b.val=temp;
    }
}