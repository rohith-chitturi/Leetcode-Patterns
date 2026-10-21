class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char mn=s.charAt(0);
        char mx=s.charAt(0);
        boolean sorted=true;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            mn=(char) Math.min(mn,ch);
            mx=(char) Math.max(mx,ch);
            if(i>0 && ch<s.charAt(i-1)){
                sorted=false;
            }
        }
        if(sorted){
            return 0;
        }
        if(n==2){
            return -1;
        }
        if(s.charAt(0)==mn || s.charAt(n-1)==mx){
            return 1;
        }
        for(int i=1;i<n-1;i++){
            char ch=s.charAt(i);
            if(ch==mn||ch==mx){
                return 2;
            }
        }
        return 3;
    }
}