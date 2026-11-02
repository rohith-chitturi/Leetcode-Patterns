class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median=nums[nums.length/2];
        int diff=0;
        for(int i:nums){
            diff+=Math.abs(i-median);
        }
        return diff;
    }
}