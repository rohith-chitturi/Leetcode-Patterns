class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();
        for(int i=left;i<=right;i++){
            int curr=i;
            boolean isselfdividing=true;
            while(curr>0){
                int digit=curr%10;
                if(digit==0||i%digit!=0){
                    isselfdividing=false;
                    break;
                }
                curr=curr/10;
            }
            if(isselfdividing){
                res.add(i);
            }
        }
        return res;
    }
}