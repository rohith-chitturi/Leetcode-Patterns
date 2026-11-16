class Solution {
    public String digitSum(String s, int k) {
        //int n=s.length();
        while(s.length()>k){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<s.length();i+=k){
                int groupSum=0;
                int end=Math.min(i+k,s.length());
                for(int j=i;j<end;j++){
                    groupSum+=s.charAt(j)-'0';
                }
                sb.append(groupSum);
            }
            s=sb.toString();
        }
        return s;
    }
}