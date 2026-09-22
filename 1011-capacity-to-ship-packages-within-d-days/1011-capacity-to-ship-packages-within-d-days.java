class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ans=-1;
        int max=Integer.MIN_VALUE;
        for(int i:weights){
            max=Math.max(max,i);
        }
        int low=max;
        int sum=0;
        for(int i:weights){
            sum+=i;
        }
        int high=sum;
        while(low<=high){
            int capacity=(low+high)/2;
            if(canShip(weights,days,capacity)){
                ans=capacity;
                high=capacity-1;
            }else{
                low=capacity+1;
            }
        }
        return ans;
    }
    public boolean canShip(int[] weights,int days,int capacity){
        int currentload=0;
        int daysused=1;
        for(int weight:weights){
            if(currentload+weight<=capacity){
                currentload+=weight;
            }else{
                daysused++;
                currentload=weight;
            }
        }
        return daysused<=days;
    }
}