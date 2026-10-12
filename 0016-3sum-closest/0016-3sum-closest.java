class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int mindiff=Integer.MAX_VALUE;
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
            int sum=nums[i]+nums[left]+nums[right];
            int diff=Math.abs(target-sum);
            if(diff<mindiff){
                mindiff=diff;
                res=sum;
            }
            if(sum==target){
                return sum;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
            }
        }
        return res;
    }
}