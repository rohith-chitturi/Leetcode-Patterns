class RandomizedSet {
    Map<Integer,Integer> hm;
    List<Integer> al;
    public RandomizedSet() {
        hm=new HashMap<>();
        al=new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)){
            return false;
        }
        al.add(val);
        int index=al.size()-1;
        hm.put(val,index);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)){
            return false;
        }
        int index=hm.get(val);
        int last=al.get(al.size()-1);
        al.set(index,last);
        hm.put(last,index);
        al.remove(al.size()-1);
        hm.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index=(int) (Math.random()*al.size());
        return al.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */