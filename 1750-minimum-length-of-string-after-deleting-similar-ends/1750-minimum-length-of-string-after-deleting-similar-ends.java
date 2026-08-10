class Solution {
    public int minimumLength(String s) {
        int left=0;
        int n=s.length();
        int right=n-1;
        while(left<right && s.charAt(left)==s.charAt(right)){
            char ch=s.charAt(left);
            while(left<=right && ch==s.charAt(left)){
                left++;
            }
            while(left<=right && ch==s.charAt(right)){
                right--;
            }
        }
        return right-left+1;
    }
}