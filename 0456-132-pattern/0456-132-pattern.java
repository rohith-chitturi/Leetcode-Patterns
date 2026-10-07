class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        st.push(nums[n-1]);
        int second=Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            int curr=nums[i];
            if(curr<second){
                return true;
            }
            while(!st.isEmpty()&&curr>st.peek()){
                second=st.pop();
            }
            st.push(curr);
        }
        return false;
    }
}