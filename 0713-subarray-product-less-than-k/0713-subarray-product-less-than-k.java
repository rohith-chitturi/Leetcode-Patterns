class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int count=0;
        int product=1;
        if(n==1){
            if(nums[0]>k){
                return 0;
            }
            return 1;
        }
        for(int right=0;right<n;right++){
            product*=nums[right];
            while(product>=k){
                product/=nums[left];
                left++;
            }
            if(product<k){
                count+=right-left+1;
            }
        }
        return count;
    }
}