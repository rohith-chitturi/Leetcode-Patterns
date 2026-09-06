class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            maxheap.add(i);
        }
        while(maxheap.size()>=2){
            int x=maxheap.poll();
            int y=maxheap.poll();
            if(x!=y){
                maxheap.add(x-y);
            }
        }
        if(maxheap.isEmpty()){
            return 0;
        }
        return maxheap.peek();
    }
}