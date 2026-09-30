class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] ans=new int[n];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                st.push('(');
                ans[i]=(st.size()-1)%2;
            }else{
                ans[i]=(st.size()-1)%2;
                st.pop();
            }
        }
        return ans;
    }
}