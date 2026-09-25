class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        int max=Integer.MIN_VALUE;
        for(int i:candies){
            max=Math.max(max,i);
        }
        int high=max;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            if(possible(candies,mid,k)){
                res=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return res;
    }
    public boolean possible(int[] candies,int mid,long k){
        long sum=0;
        for(int i=0;i<candies.length;i++){
            sum+=candies[i]/mid;
        }
        return sum>=k;
    }
}