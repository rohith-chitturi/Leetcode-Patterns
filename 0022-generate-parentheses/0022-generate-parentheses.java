class Solution {
    public List<String> generateParenthesis(int n) {
        int open=0;
        int close=0;
        List<String> res=new ArrayList<>();
        String temp="";
        backtrack(open,close,temp,res,n);
        return res;
    }
    public void backtrack(int open,int close,String temp,List<String> res,int n){
        if(open==n && close==n){
            res.add(temp);
            return ;
        }
        if(open<n){
            backtrack(open+1,close,temp+"(",res,n);
        }
        if(close<open){
            backtrack(open,close+1,temp+")",res,n);
        }
    }
}