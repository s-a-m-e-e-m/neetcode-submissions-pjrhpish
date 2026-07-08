class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        // t[i] = true if i can reach from index i to n-1
               // false if i can't reach from index i to n-1

        dp[n-1] = true; // i can always reach n-1 from n-1

        for(int i=n-2;i>=0;i--){
            for(int jump=minJump; jump<=maxJump; jump++){
                int j = i+jump;

                if(j>=n) break;

                if(s.charAt(j) == '0'){
                    if(dp[j]){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}