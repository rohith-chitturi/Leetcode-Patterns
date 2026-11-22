class Solution {
    public boolean checkString(String s) {
        boolean seenb=false;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='b'){
                seenb=true;
            }else if(seenb){
                return false;
            }
        }
        return true;
    }
}