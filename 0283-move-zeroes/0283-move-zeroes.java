class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        while(right<nums.length){
            if(nums[right]!=0){
                int temp=nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                left++;
                right++;
            }
            else{
                right++;
            }
        }
        
    }
}