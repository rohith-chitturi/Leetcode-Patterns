class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start1=intervals[0][0];
        int end1=intervals[0][1];
        int index=0;
        int n=intervals.length;
        int[][] res=new int[n][2];
        for(int i=1;i<n;i++){
            int start2=intervals[i][0];
            int end2=intervals[i][1];
            if(end1>=start2){
                start1=start1;
                end1=Math.max(end1,end2);
                continue;
            }
            res[index][0]=start1;
            res[index][1]=end1;
            end1=end2;
            start1=start2;
            index++;
        }
        res[index][0]=start1;
        res[index][1]=end1;
        return  Arrays.copyOf(res, index + 1);
    }
}