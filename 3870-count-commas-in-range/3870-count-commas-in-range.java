class Solution {
    public int countCommas(int n) {
        int count=0;
        while(n>0){
            int digit=n%10;
            count++;
            n=n/10;
        }
        if(count<=3){
            return 0;
        }
        return count-1;
    }
}