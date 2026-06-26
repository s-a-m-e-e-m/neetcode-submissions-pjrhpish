class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0, total = 0, n = stones.length;

        for(int e : stones) total += e;

        sum = total/2;
        int[][] dp = new int[n+1][sum+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(stones[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i-1]]+stones[i-1]);
                }
            }
        }

        return total - (2*dp[n][sum]);
    }
}