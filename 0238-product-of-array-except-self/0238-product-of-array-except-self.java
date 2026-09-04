class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        int[] leftproduct=new int[n];
        //leftproduct[0]=1;
        int left=1;
        for(int i=0;i<n;i++){
            leftproduct[i]=left;
            left=left*nums[i];
        }
        int[] rightproduct=new int[n];
        int right=1;
        for(int i=n-1;i>=0;i--){
            rightproduct[i]=right;
            right=right*nums[i];
        }
        for(int i=0;i<n;i++){
            res[i]=leftproduct[i]*rightproduct[i];
        }
        return res;
    }
}