class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int low=0;
        int high=cols-1;
        int[] res=new int[2];
        while(low<=high){
            int mid=(low+high)/2;
            int maxrow=0;
            for(int i=1;i<rows;i++){
                if(mat[i][mid]>mat[maxrow][mid]){
                    maxrow=i;
                }
            }
            if(mid+1<cols && mat[maxrow][mid]<mat[maxrow][mid + 1]){
                low=mid+1;
            }
            else if (mid-1>=0 && mat[maxrow][mid]<mat[maxrow][mid - 1]) {
                high=mid - 1;
            }
            else {
                return new int[]{maxrow, mid};
            }
        }
        return new int[]{-1,-1};
    }
}