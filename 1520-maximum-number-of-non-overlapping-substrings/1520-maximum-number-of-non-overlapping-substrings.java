class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] first=new int[26];
        int[] last=new int[26];
        Arrays.fill(first,-1);
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(first[c]==-1){
                first[c]=i;
            }
            last[c]=i;
        }
        List<String> result=new ArrayList<>();
        int prevend=-1;
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(first[c]!=i){
                continue;
            }
            int left=i;
            int right=last[c];
            boolean valid=true;
            for(int j=left;j<=right;j++){
                int curr=s.charAt(j)-'a';
                if(first[curr]<left){
                    valid=false;
                    break;
                }
                right=Math.max(right,last[curr]);
            }
            if(!valid){
                continue;
            }
            if(left>prevend){
                result.add(s.substring(left,right+1));
                prevend=right;
            }else{
                result.set(result.size()-1,s.substring(left,right+1));
                prevend=right;
            }
        }
        return result;
    }
}