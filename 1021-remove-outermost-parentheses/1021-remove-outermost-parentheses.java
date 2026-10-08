class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                if(!st.isEmpty()){
                    res.append("(");
                }
                st.push(ch);
            }else{
                st.pop();
                if(!st.isEmpty()){
                    res.append(")");
                }
            }
        }
        return res.toString();
    }
}