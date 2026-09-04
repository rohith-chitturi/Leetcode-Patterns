class Solution {
    public int longestWPI(int[] hours) {
        int n=hours.length;
        int[] convertedArray=new int[n];
        for(int i=0;i<n;i++){
            if(hours[i]>8){
                convertedArray[i]=1;
            }else{
                convertedArray[i]=-1;
            }
        }
        int[] prefixsum=new int[n];
        prefixsum[0]=convertedArray[0];
        for(int i=1;i<n;i++){
            prefixsum[i]=prefixsum[i-1]+convertedArray[i];
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(prefixsum[i]>0){
            ans=Math.max(ans,i+1);
            }
            for(int j=0;j<i;j++){
                if(prefixsum[i]-prefixsum[j]>0){
                    ans=Math.max(ans,i-j);
                }
            }
        }
        return ans;
    }
}