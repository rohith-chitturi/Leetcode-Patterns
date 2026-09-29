class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> hm=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for(int i:arr){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int frequency:hm.values()){
            if(!set.contains(frequency)){
                set.add(frequency);
            }else{
                return false;
            }
        }
        return true;
    }
}