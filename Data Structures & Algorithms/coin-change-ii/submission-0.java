class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);

        return solve(n-1, amount, coins, dp);
    }

    private int solve(int i, int amount, int[] coins, int[][] dp){
        if(amount==0) return 1;
        if(i<0 || amount<0) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];

        int skip = solve(i-1, amount, coins, dp);
        int take = solve(i, amount-coins[i], coins, dp);
        return dp[i][amount] = skip + take;
    }
}
