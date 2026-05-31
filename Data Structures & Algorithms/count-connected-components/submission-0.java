class Solution {
    public int countComponents(int n, int[][] edges) {
        int r = edges.length, c = edges[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        boolean[] vis = new boolean[n];
        int components = 0;

        for(int i=0;i<edges.length;i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                components += 1;
                dfs(i, vis, adj);
            }
        }

        return components;
    }

    private void dfs(int node, boolean[] vis, List<List<Integer>> adj){
        vis[node] = true;

        for(int ele : adj.get(node)){
            if(!vis[ele]) dfs(ele, vis, adj);
        }
    }
}
