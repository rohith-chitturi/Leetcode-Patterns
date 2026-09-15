class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        boolean[] used=new boolean[n];
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        backtrack(nums,used,ans,current);
        return ans;
    }
    public void backtrack(int[] nums,boolean[] used,List<List<Integer>> ans,List<Integer> current){
        if(current.size()==nums.length){
            ans.add(new ArrayList(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
               used[i]=true;
               current.add(nums[i]);
               backtrack(nums,used,ans,current); 
               current.remove(current.size()-1);
               used[i]=false;
            }
        }
    }
}