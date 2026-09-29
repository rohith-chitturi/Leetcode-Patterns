class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // PriorityQueue<Character> pq=new PriorityQueue<>(
        //     (a,b)->map.get(b)-map.get(a)
        // );
        // for(char c:map.keySet()){
        //     pq.add(c);
        // }
        // while(!pq.isEmpty()){
        //     char c=pq.poll();
        //     int freq=map.get(c);
        //     for(int i=0;i<freq;i++){
        //         res.append(c);
        //     }
        // }
        // return res.toString();//this approach is using max heap
        //now lets see bucket sort approach
        List<Character>[] bucket=new List[s.length()+1];
        for(char c:map.keySet()){
            int freq=map.get(c);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(c);
        }
        for(int i=bucket.length-1;i>=1;i--){
            if(bucket[i]!=null){
                for(char c:bucket[i]){
                    for(int j=0;j<i;j++){
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}