class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0;
        int n=nums.length;
        int totalsum=0;
        for(int i:nums){
            totalsum+=i;
        }
        int target=totalsum-x;
        if(target<0){
            return -1;
        }
        int windowsum=0;
        int len=-1;
        for(int right=0;right<n;right++){
            windowsum+=nums[right];
            while(windowsum>target){
                windowsum-=nums[left];
                left++;
            }
            if(windowsum==target){
                len=Math.max(len,right-left+1);
            }
        }
        if(len==-1){
            return -1;
        }
        return n-len;
    }
}