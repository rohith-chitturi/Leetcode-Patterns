class Solution {
    public int pivotInteger(int n) {
        int sum=n*(n+1)/2;
        int ls=0;
        for(int i=1;i<=n;i++){
            ls+=i;
            int rs=sum-ls+i;
            if(ls==rs){
                return i;
            }
        }
        return -1;
    }
}