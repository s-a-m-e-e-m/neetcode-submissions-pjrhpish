class LRUCache {

    List<int[]> list;
    int capacity;

    public LRUCache(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0] == key){
                int[] temp = list.remove(i);
                list.add(temp);
                return temp[1];
            }
        }

        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<list.size();i++){
            if(list.get(i)[0] == key){
                int[] temp = list.remove(i);
                temp[1] = value;
                list.add(temp);
                return;
            }
        }

        if(list.size()==capacity){
            list.remove(0);
        }

        list.add(new int[]{key, value});
    }
}
