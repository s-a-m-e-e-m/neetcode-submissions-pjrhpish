class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(i, j, m, n, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int r, int c, int m, int n, char[][] grid){
        grid[r][c] = '0';

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for(int[] dir : dirs){
            int nr = r+dir[0], nc = c+dir[1];

            if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]=='0') continue;

            grid[nr][nc] = '0';

            dfs(nr, nc, m, n, grid);
        }
    }
}
