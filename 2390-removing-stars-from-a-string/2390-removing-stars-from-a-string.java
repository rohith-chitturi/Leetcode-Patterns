class Solution {
    public String removeStars(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        String res="";
        for(int i=1;i<n;i++){
            char ch=s.charAt(i);
            if(ch!='*'){
                st.push(ch);
            }else{
                st.pop();
            }
        }
        while(!st.isEmpty()){
            res+=st.pop();
        }
        StringBuilder sb=new StringBuilder(res);
        return sb.reverse().toString();
    }
}