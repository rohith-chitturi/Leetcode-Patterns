class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n=nums.length;
        long[] windowCosts=new long[n-x+1];
        SlidingWindowCost window=new SlidingWindowCost();
        for(int i=0;i<n;i++){
            window.add(nums[i]);
            if(i>=x){
                window.remove(nums[i-x]);
            }
            if(i>=x-1){
                windowCosts[i-x+1]=window.getCost();
            }
        }
        long[][] dp=new long[k+1][n+1];
        for(int i=1;i<=k;i++){
            Arrays.fill(dp[i],(long) 1e18);
        }
        for(int j=1;j<=k;j++){
            for(int i=j*x;i<=n;i++){
                dp[j][i]=Math.min(dp[j][i-1],dp[j-1][i-x]+windowCosts[i-x]);
            }
        }
        return dp[k][n];
    }
    class SlidingWindowCost{
        TreeMap<Integer,Integer> left=new TreeMap<>();
        TreeMap<Integer,Integer> right=new TreeMap<>();
        long leftSum=0;
        long rightSum=0;
        int leftCount=0;
        int rightCount=0;
        public void add(int val){
            if(leftCount==0 || val<=left.lastKey()){
                left.put(val,left.getOrDefault(val,0)+1);
                leftSum+=val;
                leftCount++;
            }else{
                right.put(val,right.getOrDefault(val,0)+1);
                rightSum+=val;
                rightCount++;
            }
            balance();
        }
        public void remove(int val){
            if(left.containsKey(val) && val<=left.lastKey()){
                if(left.get(val)==1) left.remove(val);
                else left.put(val,left.get(val)-1);
                leftSum-=val;
                leftCount--;
            }else{
                if(right.get(val)==1) right.remove(val);
                else right.put(val,right.get(val)-1);
                rightSum-=val;
                rightCount--;
            }
            balance();
        }
        private void balance(){
            while(leftCount>rightCount+1){
                int maxLeft=left.lastKey();
                if(left.get(maxLeft)==1) left.remove(maxLeft);
                else left.put(maxLeft,left.get(maxLeft)-1);
                leftSum-=maxLeft;
                leftCount--;
                right.put(maxLeft,right.getOrDefault(maxLeft,0)+1);
                rightSum+=maxLeft;
                rightCount++;
            }
            while(leftCount<rightCount){
                int minRight=right.firstKey();
                if(right.get(minRight)==1) right.remove(minRight);
                else right.put(minRight,right.get(minRight)-1);
                rightSum-=minRight;
                rightCount--;
                left.put(minRight,left.getOrDefault(minRight,0)+1);
                leftSum+=minRight;
                leftCount++;
            }
        }
        public long getCost(){
            long median=left.lastKey();
            long costLeft=(median*leftCount)-leftSum;
            long costRight=rightSum-(median*rightCount);
            return costLeft+costRight;
        }
    }
}