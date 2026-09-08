class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int totalsum=0;
        for(int i:nums){
            totalsum+=i;
        }
        int prefixsum=0;
        for(int i=0;i<n;i++){
            int leftSum=nums[i]*i-prefixsum;
            int rightSum=(totalsum-prefixsum-nums[i])-nums[i]*(n-i-1);
            ans[i]=leftSum+rightSum;
            prefixsum+=nums[i];
        }
        return ans;
    }
}