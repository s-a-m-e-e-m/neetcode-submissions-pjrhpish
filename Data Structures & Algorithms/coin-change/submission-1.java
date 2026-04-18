class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        int ans = change(n-1, amount, coins, dp);
        return ans==(int) 1e9 ? -1 : ans;
    }

    private int change(int i, int amount, int[] coins, int[][] dp){
        if(amount==0) return 0;
        if(i<0 || amount<0) return (int) 1e9;
        if(dp[i][amount] != -1) return dp[i][amount];

        int notTake = 0 + change(i-1, amount, coins, dp);
        int take = 1 + change(i, amount-coins[i], coins, dp);
        return dp[i][amount] = Math.min(notTake, take);
    }
}
