class Solution {
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:nums){
            max=Math.max(i,max);
        }
        for(int i:nums){
            sum+=i;
        }
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            if(cangroup(nums,mid,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public boolean cangroup(int[] nums,int mid,int k){
        int groups=1;
        int currentsum=0;
        for(int i:nums){
            if(currentsum+i>mid){
                groups++;
                currentsum=i;
            }else{
                currentsum+=i;
            }
        }
        return groups<=k;
    }
}