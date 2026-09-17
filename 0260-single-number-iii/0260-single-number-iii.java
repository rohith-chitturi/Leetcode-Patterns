class Solution {
    public int[] singleNumber(int[] nums) {
        int n=nums.length;
        int xor=0;
        for(int num:nums){
            xor=xor^num;
        }
        int bit=xor&(-xor);
        //two groups create cheyyali ippudu
        int a=0;
        int b=0;
        //malli array traverse
        for(int num:nums){
            if((num&bit)!=0){
                a=a^num;
            }else{
                b=b^num;
            }
        }
        return new int[]{a,b};
    }
}