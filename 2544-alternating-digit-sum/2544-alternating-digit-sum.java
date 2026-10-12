class Solution {
    public int alternateDigitSum(int n) {
        int val=1;
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum=sum+(digit*val);
            val*=-1;
            n=n/10;
        }
        if(val==1){
            return -sum;
        }
        return sum;
    }
}