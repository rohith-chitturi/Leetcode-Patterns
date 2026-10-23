class Solution {
    public int sortPermutation(int[] nums) {
        int k=-1;
        boolean out=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                out=true;
                k&=nums[i];
            }
        }
        return out?k:0;
    }
}