class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        int i=0,j=n-1;
        int[] ans=new int[n];
        while(i<n){
            if(nums[i]<pivot){
                ans[left++]=nums[i];
            }
            if(nums[j]>pivot){
                ans[right--]=nums[j];
            }
            i++;
            j--;
        }
        while(left<=right){
            ans[left++]=pivot;//here we can also write right--
        }
        return ans;
    }
}