class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n=blocks.length();
        int left=0;
        int wCount=0;
        int min=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            char ch=blocks.charAt(right);
            if(ch=='W'){
                wCount++;
            }
            if(right-left+1>k){
                char leftchar=blocks.charAt(left);
                if(leftchar=='W'){
                    wCount--;
                }
                left++;
            }
            if(right-left+1==k){
                min=Math.min(min,wCount);
            }
        }
        return min;
    }
}