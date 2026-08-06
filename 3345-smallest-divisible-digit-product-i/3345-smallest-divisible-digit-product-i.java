class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
        int ans=calcprod(n);
        if(ans%t==0){
            return n;
        }
        n++;
        }
    }
    public int calcprod(int temp){
        int curr=temp;
        int prod=1;
        while(curr>0){
            int digit=curr%10;
            prod*=digit;
            curr=curr/10;
        }
        return prod;
    }
}