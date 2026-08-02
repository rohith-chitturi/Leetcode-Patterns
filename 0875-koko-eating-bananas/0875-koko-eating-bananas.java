class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++){
            max=Math.max(max,piles[i]);
        }
        int low=1;
        int high=max;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            long hour=func(piles,n,guess);
            if(hour>h){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
    private static long func(int[] a,int n,int speed){
        long hours=0;
        for(int i=0;i<n;i++){
            hours=hours+a[i]/speed;
            if((a[i]%speed)!=0){
            hours++;
        }
        }
        return hours;
    }
}