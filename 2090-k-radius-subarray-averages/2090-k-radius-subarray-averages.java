class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        int windowSize=2*k+1;
        if(windowSize>n){
            return res;
        }
        long sum=0;
        for(int i=0;i<windowSize;i++){
           sum+=nums[i]; 
        }
        res[k]=(int) (sum/windowSize);
        for(int right=windowSize;right<n;right++){
            sum+=nums[right];
            sum-=nums[right-windowSize];
            int center=right-k;
            res[center]=(int) (sum/windowSize);
        }
        return res;
    }
}