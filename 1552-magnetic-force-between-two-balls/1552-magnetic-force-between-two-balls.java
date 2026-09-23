class Solution {
    public int maxDistance(int[] position, int m) {
        int n=position.length;
        Arrays.sort(position);
        int low=1;
        int high=Math.abs(position[n-1]-position[0]);
        while(low<=high){
            int mid=(low+high)/2;
            if(canplace(position,m,mid)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    public boolean canplace(int[] position,int m,int mid){
        int balls=1;
        int lastposition=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-lastposition>=mid){
                balls++;
                lastposition=position[i];
            }
        }
        return balls>=m;
    }
}