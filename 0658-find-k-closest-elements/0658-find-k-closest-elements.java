class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->{
                int distA=Math.abs(a-x);
                int distB=Math.abs(b-x);
                if(distA!=distB){
                    return distB-distA;
                }
                return b-a;
            }
        );
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.sort(res);
        return res;
    }
}