class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] counts=new int[3];
        for(int stone:stones){
            counts[stone%3]++;
        }
        if(counts[0]%2==0){
            return counts[1]>0 && counts[2]>0;
        }else{
            return Math.abs(counts[1]-counts[2])>2;
        }
    }
}