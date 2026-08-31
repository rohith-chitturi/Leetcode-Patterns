class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows=mat.length;
        int cols=mat[0].length;
        int[] strengthArray=new int[rows];
        for(int i=0;i<rows;i++){
            int strength=0;
            for(int j=0;j<cols;j++){
                if(mat[i][j]==1){
                    strength++;
                }
            }
            strengthArray[i]=strength;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->{
                if(strengthArray[a]!=strengthArray[b]){
                    return strengthArray[b]-strengthArray[a];
                }
                return b-a;
            }
        );
        for(int i=0;i<strengthArray.length;i++){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=pq.poll();
        }
        //Arrays.sort(res);
        return res;
    }
}