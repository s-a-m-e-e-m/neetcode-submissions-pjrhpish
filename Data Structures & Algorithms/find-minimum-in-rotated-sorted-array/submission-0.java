class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int e : nums) min = Math.min(e, min);
        return min;
    }
}
