class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        long sum=0;
        long max=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(right-left+1>k){
                int num=nums[left];
                sum-=nums[left];
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)==0){
                    map.remove(num);
                }
                left++;
            }
            if(right-left+1==k && map.size()==k){
            max=Math.max(max,sum);
            }
        }
        return max;
    }
}