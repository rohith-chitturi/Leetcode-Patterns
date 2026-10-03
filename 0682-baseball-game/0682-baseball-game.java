class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        Stack<String> st=new Stack<>();
        st.push(operations[0]);
        for(int i=1;i<n;i++){
            String str=operations[i];
            if(str.equals("C")){
                st.pop();
            }else if(str.equals("D")){
                int x=Integer.parseInt(st.peek())*2;
                st.push(Integer.toString(x));
            }else if(str.equals("+")){
                int a=Integer.parseInt(st.pop());
                int b=Integer.parseInt(st.peek());
                st.push(Integer.toString(a));
                st.push(Integer.toString(a+b));
            }else{
                st.push(str);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }
        return sum;
    }
}