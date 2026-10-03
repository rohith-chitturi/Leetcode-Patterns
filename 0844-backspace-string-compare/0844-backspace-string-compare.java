class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            if(ch1=='#'){
                if(!st1.isEmpty()){
                st1.pop();
                }
            }else{
                st1.push(ch1);
            }
        }
        String str1=new String();
        while(!st1.isEmpty()){
            str1+=st1.pop();
        }
        for(int i=0;i<t.length();i++){
            char ch2=t.charAt(i);
            if(ch2=='#'){
                if(!st2.isEmpty()){
                st2.pop();
                }
            }else{
                st2.push(ch2);
            }
        }
        String str2=new String();
        while(!st2.isEmpty()){
            str2+=st2.pop();
        }
        return str1.equals(str2);
    }
}