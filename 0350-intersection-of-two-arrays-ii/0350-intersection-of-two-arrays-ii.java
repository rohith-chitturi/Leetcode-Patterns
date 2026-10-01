class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> hm1=new HashMap<>();
        Map<Integer,Integer> hm2=new HashMap<>();
        for(int i:nums1){
            hm1.put(i,hm1.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            hm2.put(i,hm2.getOrDefault(i,0)+1);
        }
        for(int i:hm1.keySet()){
            if(hm2.containsKey(i)){
                int val1=hm1.get(i);
                int val2=hm2.get(i);
                int min=Math.min(val1,val2);
                while(min>0){
                    res.add(i);
                    min--;
                }
            }
        }
        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}