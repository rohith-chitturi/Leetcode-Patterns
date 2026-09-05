class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=profits.length;
        List<int[]> proj=new ArrayList<>();
        int index=0;
        for(int i=0;i<n;i++){
            proj.add(new int[]{capital[i],profits[i]});
        }
        proj.sort((a,b)->a[0]-b[0]);
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        while(k-->0){
            while(index<n){
            if(proj.get(index)[0]>w){
                break;
            }
            maxheap.add(proj.get(index)[1]);
            index++;
            }
            if(maxheap.isEmpty()){
                break;
            }else{
                w+=maxheap.poll();
            }
        }
        return w;
    }
}