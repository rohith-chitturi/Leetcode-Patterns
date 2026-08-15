class Solution {
    public String minWindow(String s, String t) {
        int res=Integer.MAX_VALUE;
        int low=0;
        int start=0;
        char have[]=new char[256];
        char needed[]=new char[256];
        for(int i=0;i<t.length();i++){
            needed[t.charAt(i)]++;
        }
        for(int high=0;high<s.length();high++){
            have[s.charAt(high)]++;
            //information correct 
            while(correct(have,needed)){
                int len=high-low+1;
                if(res>len){
                    res=len;
                    start=low;
                }
                //removing low 
                have[s.charAt(low)]--;
                low++;
            }
        }
        if(res==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+res);
    }
    public static boolean correct(char[] have,char[] needed){
        for(int i=0;i<256;i++){
            if(have[i]<needed[i]){
                return false;
            }
        }
        return true;
    }
}