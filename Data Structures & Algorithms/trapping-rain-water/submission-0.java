class Solution {
    public int trap(int[] height) {
        int sum = 0, n = height.length;
        for(int i=0;i<n;i++){
            int lh = height[i], rh = height[i];
            for(int j=0;j<i;j++){
                lh = Math.max(lh, height[j]);
            }
            for(int j=i+1;j<n;j++){
                rh = Math.max(rh, height[j]);
            }
            sum += Math.min(lh, rh)-height[i];
        }
        return sum;
    }
}
