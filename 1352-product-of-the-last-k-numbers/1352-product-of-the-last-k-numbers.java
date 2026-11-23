class ProductOfNumbers {
    private List<Integer> prefixproducts;
    public ProductOfNumbers() {
        prefixproducts=new ArrayList<>();
        prefixproducts.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefixproducts.clear();
            prefixproducts.add(1);
        }else{
            int last=prefixproducts.get(prefixproducts.size()-1);
            prefixproducts.add(last*num);
        }
    }
    
    public int getProduct(int k) {
        int n=prefixproducts.size();
        if(k>=n){
            return 0;
        }
        return prefixproducts.get(n-1)/prefixproducts.get(n-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */