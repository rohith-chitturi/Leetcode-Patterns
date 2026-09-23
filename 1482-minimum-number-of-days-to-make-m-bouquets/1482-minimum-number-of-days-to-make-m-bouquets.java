class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long) m*k>n){
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(canMake(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean canMake(int[] bloomDay,int m,int k,int day){
        int bouquets=0;
        int consecutive=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                consecutive++;
                if(consecutive==k){
                    bouquets++;
                    consecutive=0;
                }
            }else{
                consecutive=0;
            }
        }
        return bouquets>=m;
    }
}