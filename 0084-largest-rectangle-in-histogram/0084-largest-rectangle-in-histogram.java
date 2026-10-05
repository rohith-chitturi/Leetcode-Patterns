class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int maxarea=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int index=st.pop();
                int height=heights[index];
                int rightboundary=i;
                int leftboundary;
                if(st.isEmpty()){
                    leftboundary=-1;
                }else{
                    leftboundary=st.peek();
                }
                int width=rightboundary-leftboundary-1;
                int area=height*width;
                maxarea=Math.max(maxarea,area);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int index=st.pop();
            int height=heights[index];
            int rightboundary=n;
            int leftboundary;
            if(st.isEmpty()){
                leftboundary=-1;
            }else{
                leftboundary=st.peek();
            }
            int width=rightboundary-leftboundary-1;
            int area=height*width;
            maxarea=Math.max(maxarea,area);
        }
        return maxarea;
    }
}