class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b, a));

        for(int e : stones) pq.add(e);

        int res = 0;
        while(pq.size() > 1){
            int a = pq.poll(), b = pq.poll();
            if(a==b) continue;
            else pq.add(Math.abs(a-b));
        }
        if (pq.size()>0) res = pq.poll();
        return res;
    }
}
