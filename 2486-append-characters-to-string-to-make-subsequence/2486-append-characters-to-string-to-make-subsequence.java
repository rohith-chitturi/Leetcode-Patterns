class Solution {
    public int appendCharacters(String s, String t) {
        int i=0;
        int j=0;
        int count=0;
        while(i<s.length() && j<t.length()){
            char ch1=s.charAt(i);
            char ch2=t.charAt(j);
            if(ch1==ch2){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        while(j<t.length()){
            count++;
            j++;
        }
        return count;
    }
}