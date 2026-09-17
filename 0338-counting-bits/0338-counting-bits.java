class Solution {
    public int[] countBits(int n) {
        // List<Integer> res=new ArrayList<>();
        // for(int num=0;num<=n;num++){
        //     String binary="";
        //     int temp=num;
        // while(temp>0){
        //     binary=(temp%2)+binary;
        //     temp=temp/2;
        // }
        // int count=0;
        // for(int i=0;i<binary.length();i++){
        //     if(binary.charAt(i)=='1'){
        //         count++;
        //     }
        // }
        // res.add(count);
        
        // }
        // int[] finalans=new int[res.size()];
        // for(int i=0;i<res.size();i++){
        //     finalans[i]=res.get(i);
        // }
        // return finalans;
        int[] ans=new int[n+1];
        for(int num=1;num<=n;num++){
            ans[num]=ans[num&(num-1)]+1;
        }
        return ans;
    }
}