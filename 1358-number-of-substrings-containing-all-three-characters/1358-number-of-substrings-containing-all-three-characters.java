class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int left=0;
        int count=0;
        int aCount=0;
        int bCount=0;
        int cCount=0;
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            if(ch=='a'){
                aCount++;
            }
            if(ch=='b'){
                bCount++;
            }
            if(ch=='c'){
                cCount++;
            }
            while(aCount>0&&bCount>0&&cCount>0){
                count+=n-right;
                char ch1=s.charAt(left);
                if(ch1=='a'){
                    aCount--;
                }
                if(ch1=='b'){
                    bCount--;
                }
                if(ch1=='c'){
                    cCount--;
                }
                left++;
            }
        }
        return count;
    }
}