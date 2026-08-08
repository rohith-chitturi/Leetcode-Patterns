class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int left=2;
        for(int right=2;right<nums.length;right++){
            if(nums[right]!=nums[left-2]){
                nums[left]=nums[right];
                left++;
            }
        }
        return left;
    }
}