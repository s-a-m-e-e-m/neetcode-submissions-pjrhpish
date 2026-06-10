class Solution {
    public class Pair{
        int node, cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public class Triplet implements Comparable<Triplet>{
        int node, cost, stops;
        Triplet(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }

        public int compareTo(Triplet t){
            if(this.stops==t.stops) return this.cost - t.cost;
            return this.stops - t.stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] flight : flights){
            int u = flight[0], v = flight[1], w = flight[2];
            adj.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        pq.add(new Triplet(src, 0, 0));
        while(!pq.isEmpty()){
            Triplet top = pq.poll();
            int node = top.node, cost = top.cost, stops = top.stops;
            if(stops>k) continue;

            for(Pair p : adj.get(node)){
                int totCost = cost + p.cost;
                if(totCost < dist[p.node]){
                    dist[p.node] = totCost;
                    pq.add(new Triplet(p.node, totCost, stops+1));
                }
            }
        }

        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
