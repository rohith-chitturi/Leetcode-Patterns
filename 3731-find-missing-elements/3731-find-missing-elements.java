class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Set<Integer> arr=new HashSet<>();
        // for(int i:nums){
        //     arr.add(i);
        // }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            arr.add(nums[i]);
            min=Math.min(nums[i],min);
            max=Math.max(nums[i],max);
        }
        for(int i=min;i<=max;i++){
            if(!arr.contains(i)){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }
}