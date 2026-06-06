class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int[][] dirs = {{0, 1},{1, 0}, {0, -1}, {-1, 0}};

        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if(r==n-1 && c==n-1) return t;

            for(int[] d : dirs){
                int nr = r+d[0], nc = c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    pq.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
                }
            }
        }

        return n;
    }
}
