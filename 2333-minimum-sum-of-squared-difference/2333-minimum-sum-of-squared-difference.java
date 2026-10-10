class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        long k=(long) k1+k2;
        int[] count=new int[100001];
        for(int i=0;i<n;i++){
            count[Math.abs(nums1[i]-nums2[i])]++;
        }
        for(int i=100000;i>0&&k>0;i--){
            if(count[i]>0){
                long take=Math.min((long) count[i],k);
                count[i]-=take;
                count[i-1]+=take;
                k-=take;
            }
        }
        long ans=0;
        for(int i=1;i<=100000;i++){
            if(count[i]>0){
                ans+=(long) count[i]*(long) i*i;
            }
        }
        return ans;
    }
}