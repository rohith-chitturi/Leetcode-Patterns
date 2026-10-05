class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<Integer> st=new Stack<>();
        //int count=1;
        int[] res=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
                //count++;
            }
            if(st.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=st.peek()-i;
            }
            //count=1;
            st.push(i);
        }
        return res;
    }
}