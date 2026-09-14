class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long xoverlap=Math.max(0,Math.min(rec1[2],rec2[2])-Math.max(rec1[0],rec2[0]));
        long yoverlap=Math.max(0,Math.min(rec1[3],rec2[3])-Math.max(rec1[1],rec2[1]));
        long intersection=xoverlap*yoverlap;
        if(intersection>0){
            return true;
        }
        return false;
    }
}