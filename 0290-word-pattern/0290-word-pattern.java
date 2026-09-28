class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();
        String[] words=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(!map1.containsKey(ch)){
                map1.put(ch,words[i]);
            }else{
                String str1=words[i];
                String str2=map1.get(ch);
                if(!str1.equals(str2)){
                    return false;
                }
                if(map2.get(str1)!=ch){
                    return false;
                }
            }
            String str=words[i];
            if(!map2.containsKey(str)){
                map2.put(str,ch);
            }else{
                if(!(map1.get(ch).equals(str))){
                    return false;
                }
                if(map2.get(str)!=ch){
                    return false;
                }
            }
        }
        return true;
    }
}