class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        st.push(s.charAt(0));
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}