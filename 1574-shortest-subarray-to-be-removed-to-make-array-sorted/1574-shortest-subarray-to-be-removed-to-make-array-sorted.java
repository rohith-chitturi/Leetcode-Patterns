class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left=0;
        int n=arr.length;
        int right=n-1;
        while(left+1<n && arr[left]<=arr[left+1]){
            left+=1;
        }
        while(right-1>=0 && arr[right]>=arr[right-1]){
            right-=1;
        }
        if(left==n-1){
            return 0;
        }
        int ans=Math.min(n-left-1,right);//removing either whole right or left part
        int i=0;
        int j=right;
        while(i<=left && j<n){
            if(arr[i]<=arr[j]){
                ans=Math.min(ans,j-i-1);
                i+=1;
            }else{
                j+=1;
            }
        }
        return ans;
    }
}