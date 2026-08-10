class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score =0;
        int maxscore=0;
        int n=tokens.length;
        Arrays.sort(tokens);
        int i=0;
        int j=n-1;
        while(i<=j){
            if(power>=tokens[i]){
                power-=tokens[i];
                score++;
                i++;
                maxscore=Math.max(maxscore,score);
            }
            else if(score>0){
                score-=1;
                power+=tokens[j];
                j--;
            }
            else{
                break;
            }
        }
        return maxscore;
    }
}