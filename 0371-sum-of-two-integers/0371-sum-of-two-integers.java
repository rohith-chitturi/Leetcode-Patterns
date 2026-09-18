class Solution {
    public int getSum(int a, int b) {
        int carry=-1;
        while(carry!=0){
            int sum=a^b;
            carry=(a&b)<<1;
            a=sum;
            b=carry;
        }
        return a;
    }
}