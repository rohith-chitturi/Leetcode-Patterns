class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length();
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,i);
        }
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int index=map.get(ch);
            end=Math.max(end,index);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}