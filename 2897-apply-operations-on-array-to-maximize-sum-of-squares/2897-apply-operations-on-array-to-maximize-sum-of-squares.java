class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bc=new int[32];
        int mod=1_000_000_007;
        for(int num:nums){
            for(int i=0;i<32;i++){
                if((num&(1<<i))!=0){
                    bc[i]++;
                }
            }
        }
        long sum=0;
        for(int i=0;i<k;i++){
            long num=0;
            for(int bit=0;bit<32;bit++){
                if(bc[bit]>0){
                num |=(1<<bit);
                bc[bit]--;
                }
            }
            long square=(num*num)%mod;
            sum=(sum+square)%mod;
        }
        return (int) sum;
    }
}