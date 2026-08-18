class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n=answerKey.length();
        int left=0;
        int fcount=0;
        int tcount=0;
        int max=0;
        for(int right=0;right<n;right++){
            char ch=answerKey.charAt(right);
            if(ch=='F'){
                fcount++;
            }else{
                tcount++;
            }
            while(fcount>k && tcount>k){
                //char leftchar=answerKey.charAt(left);
               if(answerKey.charAt(left)=='F'){
                fcount--;
               } else{
                tcount--;
               }
               left++;
            }
            int len=right-left+1;
            max=Math.max(max,len);
        }
        return max;
    }
}