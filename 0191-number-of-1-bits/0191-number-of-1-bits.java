class Solution {
    public int hammingWeight(int n) {
        // String bin="";
        // while(n>0){
        //     bin=(n%2)+bin;
        //     n=n/2;
        // }
        // int onecount=0;
        // for(int i=0;i<bin.length();i++){
        //     char ch=bin.charAt(i);
        //     if(ch=='1'){
        //         onecount++;
        //     }
        // }
        // return onecount;
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
}