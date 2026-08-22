class Solution {
    public boolean checkDivisibility(int n) {
        //boolean res=false;
        int sum=0;
        int temp=n;
        int prod=1;
        while(temp>0){
            int digit=temp%10;
            sum+=digit;
            prod*=digit;
            temp=temp/10;
        }
       int combined=sum+prod;
       if(n%combined==0){
        return true;
       }else{
        return false;
       }
    }
}