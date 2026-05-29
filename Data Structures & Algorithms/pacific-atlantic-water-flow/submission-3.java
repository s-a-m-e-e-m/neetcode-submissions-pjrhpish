class Solution {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int i=0;i<m;i++){
            dfs(i, 0, pac, heights);
            dfs(i, n-1, atl, heights);
        }

        for(int j=0;j<n;j++){
            dfs(0, j, pac, heights);
            dfs(m-1, j, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, boolean[][] ocean, int[][] heights){
        ocean[i][j] = true;
        for(int[] d : dirs){
            int nr = i+d[0], nc = j+d[1];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && !ocean[nr][nc] && heights[nr][nc]>=heights[i][j]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
