class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        int n=nums.length;
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            int len=right-left+1;
            if(len==k){
                maxSum=Math.max(maxSum,sum);
                sum-=nums[left];
                left+=1;
            }
        }
        return (double) maxSum/k;
    }
}