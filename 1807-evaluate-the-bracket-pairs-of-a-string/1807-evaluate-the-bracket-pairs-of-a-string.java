class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String> pair:knowledge){
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder ans=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='('){
                int j=i+1;
                while(s.charAt(j)!=')'){
                    j++;
                }
                String key=s.substring(i+1,j);
                if(map.containsKey(key)){
                    ans.append(map.get(key));
                }else{
                    ans.append("?");
                }
                i=j+1;
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }
        return ans.toString();
    }
}