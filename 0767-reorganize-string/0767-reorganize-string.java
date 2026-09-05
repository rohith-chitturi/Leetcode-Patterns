class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        int seat =0;
        String res="";
        Map<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }
        PriorityQueue<int[] > pq=new PriorityQueue<>(
            (a,b)->b[0]-a[0]
        );
        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
            pq.add(new int[]{entry.getValue(),entry.getKey()});
        }
         while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            if (seat==0 || res.charAt(seat - 1) !=(char) peek[1]) {
                res+=(char) peek[1];
                seat++;
                peek[0]--;
                if(peek[0] > 0){
                    pq.add(peek);
                }
            }else{
                if (pq.isEmpty()) {
                    return "";
                }
                int[] next = pq.poll();
                res += (char) next[1];
                seat++;
                next[0]--;
                if (next[0] > 0) {
                    pq.add(next);
                }
                pq.add(peek);
            }
        }
        return res;
    }
}