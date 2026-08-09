class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder str=new StringBuilder();
        int idx=0;
        int n=spaces.length;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(idx<n && i==spaces[idx]){
                str.append(" ");
                idx++;
            }
            str.append(ch);
        }
        return str.toString();
    }
}