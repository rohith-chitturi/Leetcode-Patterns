class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean hasnonzero=false;
        for(int num:nums){
            xor^=num;
            if(num!=0){
                hasnonzero=true;
            }
        }
        if(xor!=0){
            return nums.length;
        }
        if(!hasnonzero){
            return 0;
        }
        return nums.length-1;
    }
}