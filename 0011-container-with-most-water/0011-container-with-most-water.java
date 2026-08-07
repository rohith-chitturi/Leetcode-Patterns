class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int max=0;
        while(left<right){
            int width=right-left;
            int h=Math.min(height[left],height[right]);
            int maxwater=width*h;
            max=Math.max(max,maxwater);
            if(height[right]<height[left]){
                right--;
            }
            else{
                left++;
            }
        }
        return max;
    }
}