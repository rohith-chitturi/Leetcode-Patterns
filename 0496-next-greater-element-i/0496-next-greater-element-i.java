class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int n=nums1.length;
       int[] res=new int[n];
       Stack<Integer> st=new Stack<>();
       Map<Integer,Integer> map=new HashMap<>();
       for(int num:nums2){
        while(!st.isEmpty() && st.peek()<num){
            map.put(st.pop(),num);
        }
        st.push(num);
       }
       while(!st.isEmpty()){
        map.put(st.pop(),-1);
       }
       for(int i=0;i<nums1.length;i++){
        res[i]=map.get(nums1[i]);
       }
       return res;
    }
}