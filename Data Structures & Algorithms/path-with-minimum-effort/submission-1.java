class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0, 0, 0}); // {diff, row, col}

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int diff = curr[0], r = curr[1], c = curr[2];

            if(r==m-1 && c==n-1) return diff;
            if(dist[r][c] < diff) continue;

            for(int[] d : dirs){
                int nr = r+d[0], nc = c+d[1];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;

                int newDiff = Math.max(diff, Math.abs(heights[r][c] - heights[nr][nc]));
                if(newDiff < dist[nr][nc]){
                    dist[nr][nc] = newDiff;
                    pq.offer(new int[]{newDiff, nr, nc});
                }
            }
        }

        return 0;
    }
}