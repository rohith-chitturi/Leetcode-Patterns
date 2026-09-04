class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] suffixminimum=new int[n];
        suffixminimum[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixminimum[i]=Math.min(suffixminimum[i+1],nums[i]);
        }
        int prefixmaximum=nums[0];
        for(int i=0;i<n;i++){
            prefixmaximum=Math.max(prefixmaximum,nums[i]);
            if((prefixmaximum-suffixminimum[i])<=k){
                return i;
            }
        }
        return -1;
    }
}