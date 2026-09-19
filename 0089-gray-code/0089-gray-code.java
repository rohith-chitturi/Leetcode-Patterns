class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList<>();
        int total=1<<n;
        for(int i=0;i<total;i++){
            res.add(i^(i>>1));
        }
        return res;
    }
}