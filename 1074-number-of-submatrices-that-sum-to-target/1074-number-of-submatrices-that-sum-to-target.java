class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        int ans=0;
        for(int top=0;top<rows;top++){
            int[] colsum=new int[cols];
            for(int bottom=top;bottom<rows;bottom++){
                for(int col=0;col<cols;col++){
                    colsum[col]+=matrix[bottom][col];
                }
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);
                int sum=0;
                for(int col=0;col<cols;col++){
                    sum+=colsum[col];
                    if(map.containsKey(sum-target)){
                        ans+=map.get(sum-target);
                    }
                    map.put(sum,map.getOrDefault(sum,0)+1);
                }
            }
        }
        return ans;
    }
}