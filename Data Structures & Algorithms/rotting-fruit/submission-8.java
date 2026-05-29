class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int fresh = 0, time = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) fresh++;
                if(grid[i][j]==2) q.add(new int[]{i, j});
            }
        }

        while(fresh>0 && !q.isEmpty()){
            int len = q.size();

            for(int i=0;i<len;i++){
                int[] node = q.poll();
                int r = node[0], c = node[1];

                for(int[] d : dirs){
                    int nr = r+d[0], nc = c+d[1];

                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }

            time++;
        }

        return fresh==0 ? time : -1;
    }
}
