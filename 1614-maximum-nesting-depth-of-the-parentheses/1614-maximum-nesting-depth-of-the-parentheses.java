class Solution {
    public int maxDepth(String s) {
        // int count=0;
        // int n=s.length();
        // int max=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     char ch=s.charAt(i);
        //     if(ch=='('){
        //         count++;
        //     }
        //     if(ch==')'){
        //         count--;
        //     }
        //     max=Math.max(max,count);
        // }
        // return max;
        //using stack approach
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            if(ch==')'){
                st.pop();
            }
            max=Math.max(max,st.size());
        }
        return max;
    }
}