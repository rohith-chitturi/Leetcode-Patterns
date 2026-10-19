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
    //Brute Force Logic T.C->O(n) && S.C->O(n)
    // List<Integer> al=new ArrayList<>();
    Stack<TreeNode> asc=new Stack<>();
    Stack<TreeNode> desc=new Stack<>();
    int getSmall(){
        TreeNode small=asc.pop();
        TreeNode rightchild=small.right;
        while(rightchild!=null){
            asc.push(rightchild);
            rightchild=rightchild.left;
        }
        return small.val;
    }
    int getBig(){
        TreeNode big=desc.pop();
        TreeNode leftchild=big.left;
        while(leftchild!=null){
            desc.push(leftchild);
            leftchild=leftchild.right;
        }
        return big.val;
    }
    public boolean findTarget(TreeNode root, int k) {
    //     if(root==null){
    //         return false;
    //     }
    //     findTarget(root.left,k);
    //     al.add(root.val);
    //     findTarget(root.right,k);
    //     int low=0;
    //     int high=al.size()-1;
    //     while(low<high){
    //         int v1=al.get(low);
    //         int v2=al.get(high);
    //         if(v1+v2==k){
    //             return true;
    //         }else if(v1+v2<k){
    //             low++;
    //         }else{
    //             high--;
    //         }
    //     }
    //     return false;
    //Optimal approach
        TreeNode t=root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        t=root;
        while(t!=null){
            desc.push(t);
            t=t.right;
        }
        int s=getSmall();
        int e=getBig();
        while(s<e){
            if(s+e==k){
                return true;
            }else if(s+e<k){
                s=getSmall();
            }else{
                e=getBig();
            }
        }
        return false;
    } 
}