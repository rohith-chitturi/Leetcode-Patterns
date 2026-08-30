class Solution {
    public int minimumDeletions(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minindex=-1;
        int maxindex=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
                minindex=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxindex=i;
            }
        }
        int n = nums.length;
        int left = Math.max(minindex, maxindex) + 1;
        int right = n - Math.min(minindex, maxindex);
        int mixed1 = (minindex + 1) + (n - maxindex);
        int mixed2 = (maxindex + 1) + (n - minindex);
        return Math.min(Math.min(left, right), Math.min(mixed1, mixed2));
    }
}