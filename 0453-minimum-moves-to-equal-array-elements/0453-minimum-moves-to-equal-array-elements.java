class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int diff=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums){
            min=Math.min(min,i);
        }
        for(int i:nums){
            diff+=i-min;
        }
        return diff;
    }
}