class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int min=nums[k-1]-nums[0];
        for(int right=k;right<n;right++){
            int left=right-k+1;
            int diff=nums[right]-nums[left];
            min=Math.min(min,diff);
        }
        return min;
    }
}