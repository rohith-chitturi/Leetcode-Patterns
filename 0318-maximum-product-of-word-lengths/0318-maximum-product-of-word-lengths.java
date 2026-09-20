class Solution {
    public int maxProduct(String[] words) {
        int n=words.length;
        int[] maskedarray=new int[n];
        for(int i=0;i<n;i++){
            int mask=0;
            for(int j=0;j<words[i].length();j++){
                char ch=words[i].charAt(j);
                int k=ch-'a';
                mask=mask|(1<<k);
            }
            maskedarray[i]=mask;
        }
        int max=0;
        for(int i=0;i<maskedarray.length;i++){
            for(int j=0;j<maskedarray.length;j++){
                if((maskedarray[i]&maskedarray[j])==0){
                    max=Math.max(max,(words[i].length())*(words[j].length()));
                }
            }
        }
        return max;
    }
}