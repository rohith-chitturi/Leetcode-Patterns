class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    ans++;
                }
            }
        }
        return ans+open;
    }
}