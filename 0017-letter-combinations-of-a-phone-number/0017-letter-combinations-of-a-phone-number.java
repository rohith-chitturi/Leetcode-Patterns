class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> given=new HashMap<>();
        given.put('2',"abc");
        given.put('3',"def");
        given.put('4',"ghi");
        given.put('5',"jkl");
        given.put('6',"mno");
        given.put('7',"pqrs");
        given.put('8',"tuv");
        given.put('9',"wxyz");
        int n=digits.length();
        String diary="";
        int idx=0;
        List<String> res=new ArrayList<>();
        backtrack(digits,n,idx,diary,res,given);
        return res;
    }
    public void backtrack(String digits,int n,int idx,String diary,List<String> res,Map<Character,String> given){
        if(idx==n){
            res.add(diary);
            return ;
        }
        String choice=given.get(digits.charAt(idx));
        for(int j=0;j<choice.length();j++){
            backtrack(digits,n,idx+1,diary+choice.charAt(j),res,given);
        }
        return ;
    }
}