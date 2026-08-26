class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();
        String beautiful="";
        int left=0;
        int ones=0;
        int len=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(ch=='1'){
                ones++;
            }
            while(ones>k){
                if(ch=='1'){
                    ones--;
                }
                left++;
            }
            if(ones==k){
                while(s.charAt(left)=='0'){
                    left++;
                }
                int currentlen=right-left+1;
                if(currentlen<len){
                    len=currentlen;
                    beautiful=s.substring(left,right+1);
                }
                else if(currentlen==len){
                    String current=s.substring(left,right+1);
                    if(current.compareTo(beautiful)<0){
                        beautiful=current;
                    }
                }
            }
        }
        return beautiful;
    }
}