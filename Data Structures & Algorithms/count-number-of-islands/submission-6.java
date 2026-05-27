class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int islands = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1') {
                    dfs(i, j,m,n, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(int r, int c, int m, int n, char[][] grid){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]=='0') return;
        grid[r][c] = '0';

        dfs(r, c+1, m, n, grid);
        dfs(r+1, c, m, n, grid);
        dfs(r, c-1, m, n, grid);
        dfs(r-1, c, m, n, grid);
    }
}
