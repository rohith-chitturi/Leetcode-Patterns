class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int sumleft=0;
        int sumright=0;
        int qleft=0;
        int qright=0;
        for(int i=0;i<n/2;i++){
            if(num.charAt(i)=='?'){
                qleft++;
            }else{
                sumleft+=num.charAt(i)-'0';
            }
        }
        for(int i=n/2;i<n;i++){
            if(num.charAt(i)=='?'){
                qright++;
            }else{
                sumright+=num.charAt(i)-'0';
            }
        }
        if((qleft+qright)%2!=0){
            return true;
        }
        return (sumleft-sumright)*2 !=9*(qright-qleft);
    }
}