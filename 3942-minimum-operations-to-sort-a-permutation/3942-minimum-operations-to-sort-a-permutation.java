class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        if(n==1) return 0;
        int index0=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                index0=i;
                break;
            }
        }
        boolean isIncreasing=true;
        boolean isDecreasing=true;
        for(int i=0;i<n-1;i++){
            int curr=nums[(index0+i)%n];
            int next=nums[(index0+i+1)%n];
            if(next!=(curr+1)%n){
                isIncreasing=false;
            }
            if(curr!=(next+1)%n){
                isDecreasing=false;
            }
        }
        if(isIncreasing){
            return Math.min(index0,n-index0+2);
        }else if(isDecreasing){
            return Math.min(n-index0,index0+2);
        }
        return -1;
    }
}