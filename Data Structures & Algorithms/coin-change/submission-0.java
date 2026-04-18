class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int ans = change(n-1, amount, coins);
        return ans==(int) 1e9 ? -1 : ans;
    }

    private int change(int i, int amount, int[] coins){
        if(amount==0) return 0;
        if(i<0 || amount<0) return (int) 1e9;

        int notTake = 0 + change(i-1, amount, coins);
        int take = 1 + change(i, amount-coins[i], coins);
        return Math.min(notTake, take);
    }
}
