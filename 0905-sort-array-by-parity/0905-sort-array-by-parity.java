class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<right){
            if(nums[left]%2!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                right--;
            }else{
                left++;
            }
        }
        return nums;
    }
}