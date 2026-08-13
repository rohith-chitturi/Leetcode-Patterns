class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int n=nums.length;
        int zerocount=0;
        int max=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zerocount++;
            }
            while(zerocount>k){
                if(nums[left]==0){
                    zerocount--;
                }
                left++;
            }
            int len=right-left+1;
            max=Math.max(max,len);
        }
        return max;
    }
}