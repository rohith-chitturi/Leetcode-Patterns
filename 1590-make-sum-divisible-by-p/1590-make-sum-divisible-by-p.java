class Solution {
    public int minSubarray(int[] nums, int p) {
        int n=nums.length;
        long sum=0;
        for(int i:nums){
            sum+=i;
        }
        long rem=sum%p;
        if(rem==0) return 0;
        long newsum=0;
        int ans=Integer.MAX_VALUE;
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,-1);
        for(int i=0;i<n;i++){
            newsum+=nums[i];
            long currentrem=newsum%p;
            long x=(currentrem-rem+p)%p;
            if(map.containsKey(x)){
                ans=Math.min(ans,i-map.get(x));
            }
            map.put(currentrem,i);
        }
        return ans==Integer.MAX_VALUE || ans==n?-1:ans;
    }
}