class Solution {
    public int maxVowels(String s, int k) {
        int left=0;
        int n=s.length();
        int vowelcount=0;
        int max=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowelcount++;
            }
            //int len=right-left+1;
            if(right-left+1>k){
                char ch1=s.charAt(left);
                if(ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u'){
                    vowelcount--;
                }
                left++;
            }
            int len=right-left+1;
            if(len==k){
                max=Math.max(max,vowelcount);
            }
        }
        return max;
    }
}