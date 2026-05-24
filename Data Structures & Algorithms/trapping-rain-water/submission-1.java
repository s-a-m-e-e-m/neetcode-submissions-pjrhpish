class Solution {
    public int trap(int[] height) {
        int n = height.length, ans = 0;

        int[] maxPrefix = new int[n];
        maxPrefix[0] = height[0];
        for(int i=1;i<n;i++){
            maxPrefix[i] = Math.max(maxPrefix[i-1], height[i]);
        }

        int[] maxSuffix = new int[n];
        maxSuffix[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            maxSuffix[i] = Math.max(maxSuffix[i+1], height[i]);
        }

        for(int i=0;i<n;i++){
            ans += Math.min(maxSuffix[i], maxPrefix[i]) - height[i];
        }

        return ans;
    }
}
