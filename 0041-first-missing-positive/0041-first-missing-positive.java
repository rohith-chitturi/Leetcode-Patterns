class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> hashset=new HashSet<>();
        for(int i:nums){
            hashset.add(i);
        }
        int i=1;
        while(hashset.contains(i)){
            i++;
        }
        return i;
    }
}