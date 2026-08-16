class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0;
        long cost=0;
        long windowsum=0;
        long max=0;
        for(int right=0;right<n;right++){
            int windowlength=right-left+1;
            windowsum+=nums[right];
            cost=(long) nums[right]*windowlength-windowsum;
            while(cost>k){
                windowsum-=nums[left];
                left++;
                windowlength=right-left+1;
                cost=(long) nums[right]*windowlength-windowsum;
            }
            max=Math.max(max,right-left+1);
        }
        return (int) max;
    }
}