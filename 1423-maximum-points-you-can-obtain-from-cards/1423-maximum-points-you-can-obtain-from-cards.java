class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int total=0;
        for(int num:cardPoints){
            total+=num;
        }
        int windowSize=n-k;
        int window=0;
        for(int i=0;i<windowSize;i++){
            window+=cardPoints[i];
        }
        int min=window;
        int left=0;
        for(int right=windowSize;right<n;right++){
            window+=cardPoints[right];
            window-=cardPoints[left];
            left++;
            min=Math.min(min,window);
        }
        return total-min;
    }
}