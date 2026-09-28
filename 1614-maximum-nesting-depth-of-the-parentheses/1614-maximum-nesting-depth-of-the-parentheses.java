class Solution {
    public int maxDepth(String s) {
        int count=0;
        int n=s.length();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                count++;
            }
            if(ch==')'){
                count--;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}