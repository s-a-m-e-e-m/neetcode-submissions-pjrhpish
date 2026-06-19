class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int a = 0, b = 0, c = 0;

        for(int i=n-1;i>=0;i--){
            int res = Integer.MIN_VALUE;

            res = Math.max(res, stoneValue[i]-a);
            if(i+2<=n){
                res = Math.max(res, stoneValue[i]+stoneValue[i+1]-b);
            }
            if(i+3<=n){
                res = Math.max(res, stoneValue[i]+stoneValue[i+1]+stoneValue[i+2]-c);
            }

            c = b;
            b = a;
            a = res;
        }   

        if(a==0) return "Tie";
        return a>0 ? "Alice" : "Bob";
    }
}