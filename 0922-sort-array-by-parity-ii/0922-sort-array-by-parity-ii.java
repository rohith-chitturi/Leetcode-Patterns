class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n=nums.length;
        int even=0;
        int odd=1;
        int[] res=new int[n];
        for(int i:nums){
            if(i%2==0){
                res[even]=i;
                even+=2;
            }
            else{
                res[odd]=i;
                odd+=2;
            }
        }
        return res;
    }
}