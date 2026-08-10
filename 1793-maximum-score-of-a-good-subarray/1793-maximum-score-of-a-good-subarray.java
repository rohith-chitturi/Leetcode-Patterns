class Solution {
    public int maximumScore(int[] nums, int k) {
        int left=k;
        int right=k;
        int n=nums.length;
        int min=nums[k];
        int ans=nums[k];
        while(left>0 || right<n-1){
            if(left==0){
                right++;
            }
            else if(right==n-1){
                left--;
            }
            else if(nums[left-1]>nums[right+1]){
                left--;
            }
            else{
                right++;
            }
            min=Math.min(min,Math.min(nums[left],nums[right]));
            int length=right-left+1;
            ans=Math.max(ans,min*length);
        }
        return ans;
    }
}