class Solution {
    public int minFlips(int a, int b, int c) {
        int flips=0;
        for(int i=0;i<32;i++){
            int abit=(a>>i)&1;
            int bbit=(b>>i)&1;
            int cbit=(c>>i)&1;
            if(cbit==1){
                if(abit==0 && bbit==0){
                    flips++;
                }
            }else{
                flips+=abit+bbit;
            }
        }
        return flips;
    }
}