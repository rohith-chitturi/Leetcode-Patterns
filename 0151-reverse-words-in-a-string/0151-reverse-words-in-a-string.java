class Solution {
    public String reverseWords(String s) {
        String[] words=s.trim().split("\\s+");
        int n=words.length;
        int left=0;
        int right=n-1;
        while(left<right){
            String temp=words[left];
            words[left]=words[right];
            words[right]=temp;
            left++;
            right--;
        }
        String res=String.join(" ",words);
        return res;
    }
}