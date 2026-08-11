class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left=0;
        int n=arr.length;
        int sum=0;
        int count=0;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            //int avg=sum/k;
            if(right-left+1>k){
                sum-=arr[left];
                left++;
            }
            int len=right-left+1;
            if(len==k){
                if(sum>=k*threshold){
                    count++;
                }
            }
        }
        return count;
    }
}