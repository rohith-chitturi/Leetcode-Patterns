class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set=new HashSet<>(dictionary);
        StringBuilder res=new StringBuilder() ;
        String[] words=sentence.split(" "); 
        for(String word:words){
            boolean found=false;
            for(int length=1;length<=word.length();length++){
                String ss=word.substring(0,length);
                if(set.contains(ss)){
                    res.append(ss).append(" ");
                    found=true;
                    break;
                }
            }
            if(!found){
                res.append(word).append(" ");
            }
        }
        return res.toString().trim();
    }
}