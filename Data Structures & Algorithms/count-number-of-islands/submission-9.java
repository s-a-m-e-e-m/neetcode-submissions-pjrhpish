class Solution {

    public int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    bfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void bfs(int i, int j, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        grid[i][j]='0';
        q.add(new int[]{i,j});

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for(int[] d : directions){
                int nr = row+d[0], nc = col+d[1];

                if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc]=='1'){
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
