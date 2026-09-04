class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=0;
        int arraysum=0;
        for(int num:nums){
            arraysum+=num;
        }
        for(int i=0;i<n;i++){
            right=arraysum-left-nums[i];
            if(left==right){
                return i;
            }
            left+=nums[i];
        }
        return -1;
    }
}