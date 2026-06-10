class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 0, maxI = 0, maxJ = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            sb.append(s.charAt(i));
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==sb.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                
                    if((dp[i][j] > maxLen) && (n-j)+dp[i][j]-1==i-1){
                        maxLen = dp[i][j];
                        maxI = i; 
                        maxJ = j;
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int i = n, j = n;
        while(maxI>0 && maxJ>0 && dp[maxI][maxJ]>0){
            res.append(s.charAt(maxI-1));
            maxI--; maxJ--;
        }

        return res.reverse().toString();
    }
}