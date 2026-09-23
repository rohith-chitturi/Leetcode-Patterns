class Solution {
    public int mySqrt(int x) {
        int low=1;
        int high=x/2;
        if(x==1){
            return 1;
        }
        while(low<=high){
            int mid=(low+high)/2;
            if(mid>x/mid){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return high;
    }
}