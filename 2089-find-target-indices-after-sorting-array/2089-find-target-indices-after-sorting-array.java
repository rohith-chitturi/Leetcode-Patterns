class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // List<Integer> res=new ArrayList<>();
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]==target){
        //         res.add(i);
        //     }
        // }
        // return res;
        int smallercount=0;
        int targetcount=0;
        for(int num:nums){
            if(num<target){
                smallercount++;
            }else if(num==target){
                targetcount++;
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<targetcount;i++){
            res.add(smallercount+i);
        }
        return res;
    }
}