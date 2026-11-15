class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        long[] prefix=new long[n+1];
        prefix[0]=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+arr[i-1];
        }
        long evens=0;
        long odds=0;
        long mod=1000000007;
        for(long i:prefix){
            if(i%2==0){
                evens++;
            }else{
                odds++;
            }
        }
        long total=(evens*odds)%mod;
        return (int) total;
    }
}