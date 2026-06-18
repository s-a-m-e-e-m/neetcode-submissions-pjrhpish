class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        
        for(int j=0;j<n;j++) dp[n-1][j] = triangle.get(n-1).get(j);

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = triangle.get(i).get(j) + dp[i+1][j];
                int downRight = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, downRight);
            }
        }

        return dp[0][0];
    }
}