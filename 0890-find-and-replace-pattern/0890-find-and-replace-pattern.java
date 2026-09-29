class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            Map<Character,Character> wordmap=new HashMap<>();
            Map<Character,Character> patternmap=new HashMap<>();
            boolean valid=true;
            for(int j=0;j<words[i].length();j++){
                char ch1=words[i].charAt(j);
                char ch2=pattern.charAt(j);
                if(patternmap.containsKey(ch1)){
                    if(patternmap.get(ch1)!=ch2){
                        valid=false;
                        break;
                    }
                }
                if(wordmap.containsKey(ch2)){
                    if(wordmap.get(ch2)!=ch1){
                        valid=false;
                        break;
                    }
                }
                patternmap.put(ch1,ch2);
                wordmap.put(ch2,ch1);
            }
            if(valid){
                res.add(words[i]);
            }
        }
        return res;
    }
}