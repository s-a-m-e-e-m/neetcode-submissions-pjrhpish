class Solution {
    public int hammingWeight(int n) {
        int ones = Integer.bitCount(n);
        return ones;
    }
}
