class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int n=nums.length;
        int high=n-1;
        int res=-1;
        int[] result=new int[2];
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                res=mid;
                high=mid-1;
            }
        }
        result[0]=res;
        low=0;
        high=n-1;
        res=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]<target){
                low=mid+1;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                res=mid;
                low=mid+1;
            }
        }
        result[1]=res;
        return result;
    }
}