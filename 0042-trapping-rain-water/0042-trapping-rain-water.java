class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftmax=0;
        int rightmax=0;
        int water=0;
        while(left<=right){
            leftmax=Math.max(leftmax,height[left]);
            rightmax=Math.max(rightmax,height[right]);
            if(leftmax<rightmax){
                water+=leftmax-height[left];
                left++;
            }
            else{
                water+=rightmax-height[right];
                right--;
            }
        }
        return water;
    }
}