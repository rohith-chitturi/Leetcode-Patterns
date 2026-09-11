class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> hashset=new HashSet<>();
        for(int i=0;i<digits.length;i++){
            for(int j=0;j<digits.length;j++){
                for(int k=0;k<digits.length;k++){
                    if(i==j || i==k || j==k){
                        continue;
                    }
                    if(digits[i]==0){
                        continue;
                    }
                    if(digits[k]%2!=0){
                        continue;
                    }
                    int number=digits[i]*100+digits[j]*10+digits[k];
                    hashset.add(number);
                }
            }
        }
        return hashset.size();
    }
}