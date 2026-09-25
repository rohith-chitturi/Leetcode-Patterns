class Solution {
    public int findDuplicate(int[] nums) {
       int n=nums.length;
       int low=1;
       int high=n-1;
       while(low<=high){
        int mid=(low+high)/2;
        if(countPossibilities(nums,mid)){
            high=mid-1;
        }else{
            low=mid+1;
        }
       }
       return low;
    }
    public boolean countPossibilities(int[] nums,int mid){
        int count=0;
        for(int i:nums){
            if(i<=mid){
                count++;
            }
        }
        return count>mid;
    }
}