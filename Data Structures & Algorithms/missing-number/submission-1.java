class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length, xorr = n;
        for(int i=0;i<n;i++){
            xorr ^= i ^ nums[i];
        }
        return xorr;
    }
}