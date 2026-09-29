class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        String res="";
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->map.get(b)-map.get(a)
        );
        for(char c:map.keySet()){
            pq.add(c);
        }
        while(!pq.isEmpty()){
            char c=pq.poll();
            int freq=map.get(c);
            for(int i=0;i<freq;i++){
                res+=c;
            }
        }
        return res;
    }
}