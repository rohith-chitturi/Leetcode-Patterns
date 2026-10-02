class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:hand){
            if(map.get(i)==0){
                continue;
            }
            for(int j=0;j<groupSize;j++){
                int current=i+j;
                if(!(map.containsKey(current)) || map.get(current)==0){
                    return false;
                }
                map.put(current,map.get(current)-1);
            }
        }
        return true;
    }
}