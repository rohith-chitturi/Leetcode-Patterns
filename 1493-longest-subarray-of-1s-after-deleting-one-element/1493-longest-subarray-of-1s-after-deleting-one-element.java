class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0;
        int zerocount=0;
        int max=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                zerocount++;
            }
            while(zerocount>1){
                if(nums[left]==0){
                    zerocount--;
                }
                left++;
            }
            int len=right-left;
            max=Math.max(max,len);
        }
        return max;
    }
}