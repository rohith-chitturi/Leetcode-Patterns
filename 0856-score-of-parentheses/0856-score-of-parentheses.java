class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int score=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(score);
                score=0;
            }else{
                score=st.pop()+Math.max(score*2,1);
            }
        }
        return score;
    }
}