class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int minsum=Integer.MAX_VALUE;
        for(int len=l;len<=r;len++){
            for(int i=0;i<=n-len;i++){
                int currentsum=0;
                for(int j=i;j<i+len;j++){
                    currentsum+=nums.get(j);
                }
                if(currentsum>0){
                    minsum=Math.min(minsum,currentsum);
                }
            }
        }
        return minsum==Integer.MAX_VALUE?-1:minsum;
    }
}