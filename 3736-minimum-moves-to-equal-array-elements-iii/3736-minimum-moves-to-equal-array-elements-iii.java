class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        for(int i:nums){
            sum+=max-i;
        }
        return sum;
    }
}