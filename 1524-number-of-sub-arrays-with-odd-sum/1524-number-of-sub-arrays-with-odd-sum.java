class Solution {
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        long[] prefixsum=new long[n+1];
        prefixsum[0]=0;
        for(int i=1;i<=n;i++){
            prefixsum[i]=prefixsum[i-1]+arr[i-1];
        }
        long even=0;
        long odd=0;
        for(long i:prefixsum){
            if(i%2==0){
                even++;
            }else{
                odd++;
            }
        }
        long ans=(even*odd)%1000000007;
        return  (int) ans;
    }
}