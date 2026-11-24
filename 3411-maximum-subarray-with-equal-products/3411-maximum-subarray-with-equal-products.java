class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            int prod=1;
            int lcm=1;
            int gcd=0;
            for(int j=i;j<n;j++){
                prod*=nums[j];
                lcm=LCM(lcm,nums[j]);
                gcd=GCD(gcd,nums[j]);
                if(prod==(lcm*gcd)){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
    public int LCM(int a,int b){
        return (a/GCD(a,b)*b);
    }
    public int GCD(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}