class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long,Integer> map=new HashMap<>();
        for(List<Integer> row:wall){
            long pos=0;
            for(int i=0;i<row.size()-1;i++){
                pos+=row.get(i);
                map.put(pos,map.getOrDefault(pos,0)+1);
            }
        }
        int maxgaps=0;
        for(int gaps:map.values()){
            maxgaps=Math.max(maxgaps,gaps);
        }
        return wall.size()-maxgaps;
    }
}