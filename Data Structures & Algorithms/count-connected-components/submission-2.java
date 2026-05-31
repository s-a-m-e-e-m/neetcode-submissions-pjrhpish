class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[n];
        int components = 0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                components++;
                bfs(i, vis, adj);
            }
        }

        return components;
    }

    private void bfs(int node, boolean[] vis, List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int ele = q.poll();
            vis[ele] = true;

            for(int neigh : adj.get(ele)){
                if(!vis[neigh]){
                    q.add(neigh);
                }
            }
        }
    }
}
