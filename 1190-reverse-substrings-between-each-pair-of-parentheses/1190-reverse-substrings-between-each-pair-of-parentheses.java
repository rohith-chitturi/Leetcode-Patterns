class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<String> st=new Stack<>();
        String current="";
        //String res="";
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(current);
                current="";
            }
            else if (ch==')'){
                StringBuilder sb=new StringBuilder(current);
                String previous=st.pop();
                current=previous+sb.reverse();
            }
            else{
                current+=ch;
            }
        }
        return current;
    }
}