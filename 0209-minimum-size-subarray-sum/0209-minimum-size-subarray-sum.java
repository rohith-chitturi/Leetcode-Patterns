import java.util.*;
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int n=nums.length;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(sum>=target){
                int len=right-left+1;
                min=Math.min(min,len);
                sum-=nums[left];
                left++;
            } 
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}