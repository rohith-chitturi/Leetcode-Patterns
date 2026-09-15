class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n=candidates.length;
        int index=0;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> choices=new ArrayList<>();
        int sum=0;
        backtrack(n,candidates,index,choices,res,sum,target);
        return res;
    }
    public void backtrack(int n,int[] candidates,int index,List<Integer> choices,List<List<Integer>> res,int sum,int target){
        if(index==n){
            if(sum==target){
                res.add(new ArrayList<>(choices));
                return;
            }
            if(sum>target){
            return;
            }
            return;
        }
        //not taking choice, okkavela theeskokapothe direct mundhuki vellipovadame
        backtrack(n,candidates,index+1,choices,res,sum,target);
        //ippudu choice 2 enti, theeskovaali but with one condition
        if(candidates[index]+sum<=target){//e condition satisfy aithene we can take that choice
            choices.add(candidates[index]);
            sum=sum+candidates[index];
            backtrack(n,candidates,index,choices,res,sum,target);
            choices.remove(choices.size()-1);
            sum=sum-candidates[index];
        }
        return;
    }
}