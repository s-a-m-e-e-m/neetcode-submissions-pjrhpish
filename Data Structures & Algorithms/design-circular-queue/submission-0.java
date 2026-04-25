class MyCircularQueue {
    int[] queue;
    int r, f;
    public MyCircularQueue(int k) {
        queue = new int[k];
        r = -1;
        f = -1;
    }
    
    public boolean enQueue(int value) {
        // queue is full
        if((r+1)%queue.length==f) return false;

        else{
            if(f==-1) f = 0;
            r = (r+1)%queue.length;
            queue[r] = value;
        }

        return true;
    }
    
    public boolean deQueue() {
        // no elements
        if(f==-1){
            return false; 
        }
        // only last element
        if(f==r){
            f = -1; r = -1;
        }
        else f = (f+1)%queue.length;

        return true;
    }
    
    public int Front() {
        if(f==-1) return -1;
        return queue[f];
    }
    
    public int Rear() {
        if(r==-1) return -1;
        return queue[r];
    }
    
    public boolean isEmpty() {
        return f==-1;
    }
    
    public boolean isFull() {
        return (r+1)%queue.length == f;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */