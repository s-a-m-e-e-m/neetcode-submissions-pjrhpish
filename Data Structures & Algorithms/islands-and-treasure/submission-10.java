class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];

            for(int[] d : dirs){
                int nr = r+d[0], nc = c+d[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==2147483647){
                    grid[nr][nc] = grid[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
