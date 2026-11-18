class Solution {
    public int minChanges(String s) {
        int min=0;
        int n=s.length();
        for(int i=0;i<n;i+=2){
            char ch=s.charAt(i);
            char ch1=s.charAt(i+1);
            if(ch!=ch1){
                min++;
            }
        }
        return min;
    }
}