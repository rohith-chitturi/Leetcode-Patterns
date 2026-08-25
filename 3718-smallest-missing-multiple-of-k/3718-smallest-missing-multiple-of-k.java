class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        //int prod=1;
        for(int i=1;i<200;i++){
           int prod=i*k;
           if(!set.contains(prod)){
            return prod;
           } 
        }
        return -1;
    }
}