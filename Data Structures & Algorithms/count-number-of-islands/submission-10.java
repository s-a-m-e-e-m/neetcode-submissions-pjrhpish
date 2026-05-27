class Solution {
    int[][] directions = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(i, j, m, n, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(int i, int j, int m, int n, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = '0';

        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0], c = node[1];
            for(int[] dir : directions){
                int nr = r+dir[0], nc = c+dir[1];

                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
