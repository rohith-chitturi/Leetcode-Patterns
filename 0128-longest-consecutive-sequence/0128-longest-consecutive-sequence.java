class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Set<Integer> hashset=new HashSet<>();
        for(int i:nums){
            hashset.add(i);
        }
        int longest=0;
        for(int x:hashset){
            if(!hashset.contains(x-1)){
                int count=1;
                int current=x;
                while(hashset.contains(current+1)){
                    current++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}