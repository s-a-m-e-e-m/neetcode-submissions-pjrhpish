class Solution {
    private int solve(int i, int n, int[] stone, int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=Integer.MIN_VALUE) return dp[i];

        int res = stone[i] - solve(i+1, n, stone, dp);
        if(i+1<n)
        res = Math.max(res, stone[i]+stone[i+1]-solve(i+2, n, stone, dp));
        if(i+2<n)
        res = Math.max(res, stone[i]+stone[i+1]+stone[i+2]-solve(i+3, n, stone, dp));

        return dp[i] = res;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MIN_VALUE);

        int res = solve(0, n, stoneValue, dp);
        if(res==0) return "Tie";
        return res>0 ? "Alice" : "Bob";
    }
}