class Solution {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        int m=s.length();
        int n=t.length();
        while(i<m && j<n){
            char ch1=s.charAt(i);
            char ch2=t.charAt(j);
            if(ch1==ch2){
                i++;
                j++;
            }else{
            j++;
            }
        }
        return i==s.length();
    }
}