class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        int[] res=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->map.get(b)-map.get(a)
        );
        for(int key:map.keySet()){
            pq.add(key);
        }
        for(int i=0;i<k;i++){
            res[i]=pq.poll();
        }
        return res;
    }
}