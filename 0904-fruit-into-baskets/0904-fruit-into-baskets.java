class Solution {
    public int totalFruit(int[] fruits) {
        int left=0;
        int res=-1;
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            freq.put(fruits[right],freq.getOrDefault(fruits[right],0)+1);
            while(freq.size()>2){
                int leftfruit=fruits[left];
                freq.put(leftfruit,freq.get(leftfruit)-1);
                if (freq.get(leftfruit) == 0){
                    freq.remove(leftfruit);
                }
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}